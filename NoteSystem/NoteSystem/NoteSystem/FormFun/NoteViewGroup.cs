using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using NoteSystem.Modles.Node;
using NoteSystem.DataManage;
using NoteSystem.Views.Message;
using NoteSystem.Modles;



namespace NoteSystem.Views.Component
{
    public partial class NoteViewGroup
    {

        private NoteType noteType;

        private int  startY;
        private List<NoteView> allviews;
        //便签操作对象
        private NoteOper oper;
        private NoteEditBox noteEditBox;
        private TreeView blocks;//空间
        public NoteViewGroup(NoteType noteType, TreeView blocks)
        {
            allviews = new List<NoteView>();
            this.blocks = blocks;
            startY = 10;
            oper = new NoteOper(noteType.NoteBlock.Username,this);
            InitializeComponent();

            noteEditBox = new NoteEditBox(oper);
            noteEditBox.Dock = System.Windows.Forms.DockStyle.Fill;
          //  this.Controls.Add(neb);

            this.noteType = noteType;

            initView();

             loadData();
        }

        /// <summary>
        /// 移动节点
        /// </summary>
        public void MoveNote()
        {
            NodeOper no = new NodeOper(blocks);
            Note note = oper.NowSelectNoetView.Note;
            no.Fun = () => {
                if (no.SelectTo!=null)//判断是否xuan'z两个
                {
                    
                   Query qu= oper.MoveNoteNode(note, no.SelectTo.Tag as NoteType);
                    if (qu.Querys)
                    {
                        NoteMsg.Show("提示","移动成功！");
                        loadData();
                        AptView();
                    }
                    else
                    {
                        NoteMsg.Show("错误", qu.Msg);
                    }
                }

            };
            no.CopyNote();
        }

          

        public void FlushLayout(NoteType nt)
        {
            this.noteType = nt;
            initView();
            loadData();
            AptView();
        }
        private void initView()
        {
            tslabNoteType.Text = noteType.Title;
            
        }
        /// <summary>
        /// 加载数据
        /// </summary>
        private void loadData()
        {
            clearLayout();
            BtnImpTxt.Enabled = false;
            noteType = oper.getType(noteType);//获取文件中的最新type
            
            int i = 0;
            oper.NowSelectNoetView = null;
           foreach (NoteNode nn in noteType.AllNode)
            {
                if(nn is Note) { 
                   NoteView nv = new NoteView(nn as Note, oper);
                    string ns = (nn as Note).Msg.MsgText;
                    string txt = "类型："+nn.ParentNode.Title+"\r\n" +
                        "标题："+nn.Title+"\r\n" +
                        "简介："+(ns.Length>10?ns.Substring(0,10):ns);
                    toolTip1.SetToolTip(nv,txt);

                    nv.Parent = this.PanelBoxy;
                    if (oper.NowSelectNoetView == null)
                        oper.NowSelectNoetView = nv;
                   
                    addControls(nv);
                }
            }
        }
        /// <summary>
        /// 适配视图
        /// </summary>
        private void AptView()
        {
            int maxW = PanelBoxy.Width-20;//获取最大宽度
            int mrg = 10;
            int x = mrg;
            int y = startY;

          

            NoteView notev = new NoteView(null, oper);
            int w = notev.Width;
            int h = notev.Height;


       
            //最大每行容纳个数
            int clos = maxW / (w + mrg);
            int width = (maxW / clos - mrg);//得出最后宽度
            w = width;
            int i = 0;
            int sunY = 0;
            for (int j = 0; j < this.PanelBoxy.Controls.Count;j++) {
                Control nv = PanelBoxy.Controls[j];
                //  Console.WriteLine("X:{0} Y{1} MW:{2} W:{3}", x, y, maxW, w);
                nv.Width = width;
                nv.Left = x;
                nv.Top = y;
                x += (w + mrg);
                i++;
                if (i >= clos)
                {
                    x = mrg;
                    y += (h + mrg);
                    i = 0;
                    sunY += (h + mrg);

                }
               
            }
            vScrollBar1.Maximum = sunY;
          
        }
        /// <summary>
        /// 创建新的便签
        /// </summary>
        public void CreateNewNote()
        {
            Note note = new Note(noteType);//创建新的节点
            clearLayout();//清除布局
            setEditLayout();//设置布局
            noteEditBox.CreateNote(note);//创建新的节点
            
        }
        /// <summary>
        /// 复制节点
        /// </summary>
        public void CopyNote()
        {
            NodeOper no = new NodeOper(blocks);
            no.Oepr = oper;
            Note n = oper.NowSelectNoetView.Note;
           // Console.WriteLine("1 "+oper.NowSelectNoetView);
            no.Fun = () => {
                if (no.SelectTo != null)//判断是否xuan'z两个
                {
                  
                   
                    Query qu = no.Oepr.CopyNoteNode(n, no.SelectTo.Tag as NoteType);
                    if (qu.Querys)
                    {
                        NoteMsg.Show("提示", "复制成功！");
                        loadData();
                        AptView();
                    }
                    else
                    {
                        NoteMsg.Show("错误", qu.Msg);
                    }
                }

            };
            no.CopyNote();
          //  Console.WriteLine("3 " + oper.NowSelectNoetView);
        }

        /// <summary>
        /// 清除布局
        /// </summary>
        private void clearLayout()
        {
            PanelBoxy.Controls.Clear();
        }
        /// <summary>
        /// 设置控件 
        /// </summary>
        /// <param name="con"></param>
        private void setControls(Control con)
        {
            clearLayout();
            this.PanelBoxy.Controls.Add(con);

        }
        /// <summary>
        /// 编辑便签
        /// </summary>
        public void updateNote()
        {
            if (oper.NowSelectNoetView != null)
            {
                clearLayout();//清除布局
                noteEditBox.EditNote(oper.NowSelectNoetView.Note);
                setEditLayout();
            }
            else
            {
                NoteMsg.Show("提示","请选择需要修改的便签！");
            }
        }
        public void editNote(Note note)
        {
            clearLayout();//清除布局
            noteEditBox.EditNote(note);
            setEditLayout();
        }
        /// <summary>
        /// 添加控件
        /// </summary>
        /// <param name="con"></param>
        private void addControls(Control con)
        {
            
            this.PanelBoxy.Controls.Add(con);

        }
        /// <summary>
        /// 设置编辑布局
        /// </summary>
        /// <param name="n"></param>
        public void setEditLayout()
        {
            BtnImpTxt.Enabled = true;
            
            setControls(noteEditBox);
        }




    }
}
