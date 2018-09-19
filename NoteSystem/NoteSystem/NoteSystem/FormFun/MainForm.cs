using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.DataManage;
using NoteSystem.Modles;
using System.Windows.Forms;
using NoteSystem.Views.Component;
using NoteSystem.Views.Message;
namespace NoteSystem.Views
{
    partial class MainForm
    {
        private string userName;
        /// <summary>
        /// 获取当前操作的用户名
        /// </summary>
        public string UserName
        {
            get
            {
                return userName;
            }

            set
            {
                userName = value;
            }
        }
        /// <summary>
        /// 信息操作类
        /// </summary>
        private UserInfoOper oper;

        private NoteBlockOper blockOper;
        public MainForm(string name)
        {
            this.userName = name;
            oper = new UserInfoOper();
            blockOper = new NoteBlockOper(name);
            InitializeComponent();
            InitView();
            
        }
       
        private void showUserInfo()
        {
            UserInfoControl uic = new UserInfoControl(userName, oper, this);
            ClearLayou();
            SetControl(uic);
        }

        private void InitView()
        {
            UserInfo userInfo = oper.getUserInfo(userName);//获取用户信息
            if(userInfo.HeadImg!=null)//设置头像
            this.picUserHeadImg.Image = userInfo.HeadImg;
            string t = userInfo.Age+" "+userInfo.Sex+"\r\n"+userInfo.UserNamr + ":" + userInfo.Slogan;
            toolTip1.SetToolTip(labUserName,t);
            toolTip1.SetToolTip(picUserHeadImg, t);
            this.labUserName.Text = userName;
            
            showBlock();
        }

        private void  LodaView()
        {

        }


        public void FlushView()
        {
            InitView();
        }

        /// <summary>
        /// 加载类型信息
        /// </summary>
        private void showBlock()
        {
            //获取节点块
            NoteBlock note = oper.getNoteBlock(UserName);

            blocks.Nodes.Clear();
            //创建最大根节点
            TreeNode tn1 = new TreeNode(note.Title);
            tn1.Tag = note;
            tn1.ToolTipText = "创建时间：" + note.CreateTime.ToShortDateString();
           
            //创建回收站
            TreeNode tn = new TreeNode(note.Recycle.Title);
            tn.Tag = note.Recycle;

            addBlockType(tn, note.Recycle);

            tn.ToolTipText = "创建时间：" + note.Recycle.CreateTime.ToShortDateString();
            tn1.Nodes.Add(tn);
            foreach (NoteNode  nn in note.AllNode)
            {
                if (nn is NoteType) {
                    NoteType nt = nn as NoteType;
                    tn = new TreeNode(nt.Title);
                    tn.Tag = nt;
                    tn.ToolTipText =nt.Reamark+"["+ nt.CreateTime.ToShortDateString()+"]";
                    tn1.Nodes.Add(tn);
                    addBlockType(tn, nt);
                }
            }
            blocks.Nodes.Add(tn1);
            tn1.Expand();
        }
        /// <summary>
        /// 递归函数
        /// </summary>
        /// <param name="ptn"></param>
        /// <param name="nt"></param>
        private void addBlockType(TreeNode ptn, NoteType nt)
        {
            foreach (NoteNode nn in nt.AllNode)
            {
                if (nn is NoteType)
                {
                    NoteType n = nn as NoteType;
                    TreeNode tn = new TreeNode(n.Title);
                    tn.Tag = n;
                    tn.ToolTipText = n.Reamark + "[" + n.CreateTime.ToShortDateString() + "]"; ;
                   
                    //递归调用
                    addBlockType(tn, n);
                    ptn.Nodes.Add(tn);
                }
            }
        }
        /// <summary>
        /// 创建节点
        /// </summary>
        private void CreateType()
        {


            TreeNode tn = blocks.SelectedNode;//获取选中的节点
            if (tn == null)
            {
                NoteMsg.Show("提示", "请选择存放新类型的类型节点");
                ClearLayou();
                return;
            }
            if (tn.Text=="回收站" )
            {
                NoteMsg.Show("提示", "无法在修改或在回收站类型下创建新的类型");
                ClearLayou();
                return;
            }
            if (tn.Level < 1)
            {
                NoteMsg.Show("提示", "无法在根类型下创建新的类型");
                return;
            }
            //判断的操作是否和现在的操作一样
            if(SpBody.Panel2.Controls.Count>0)
            {
                if(SpBody.Panel2.Controls[0] is CreateTypeControl)
                {
                    CreateTypeControl ct = SpBody.Panel2.Controls[0] as CreateTypeControl;
                    ct.FlushData(tn, blockOper);
                    return;
                }
            }
            //清除面板
            ClearLayou();
            CreateTypeControl ctc = new CreateTypeControl(tn, blockOper);



            ctc.Dock = DockStyle.Fill;
            this.SpBody.Panel2.Controls.Add(ctc);

        }
        private void DeleteType()
        {
            TreeNode tn = blocks.SelectedNode;
            if(tn== null)
            {
                NoteMsg.Show("提示","请选择需要删除的类型！");
               
                return;
            }
            if (tn.Level < 2)
            {
                NoteMsg.Show("提示", "无法删除根节点！");
             
                return;
            }
            NoteNode nn = tn.Tag as NoteNode;
            if (NoteMsg.Show("提示","是否删除"+tn.Text+" 以及当前类型下所有便签") == DialogResult.Cancel)
                return;
           Query qu= blockOper.DeleteNoteNode(nn);
            if (qu.Querys)
            {
                NoteMsg.Show("提示", "删除成功！");
                tn.Remove();
            }
            else
            {
                NoteMsg.Show("提示", qu.Msg);
            }

        }
        private void ClearLayou()
        {
            this.SpBody.Panel2.Controls.Clear();
        }
        /// <summary>
        /// 清除内边距
        /// </summary>
        private void clearPadding()
        {
            this.SpBody.Panel2.Padding = new Padding(0);
        }
        /// <summary>
        /// 节点选择,目的是为了每次点击所有节点时，都会实时响应，例如我正在添加节点
        /// 当我再次选中TreeNode时依然继续添加节点,
        /// 判断依据，SpBody.Panel2中根据子Control的类型来判断
        /// </summary>
        private void BlockSelect()
        {
            //if (SpBody.Panel2.Controls.Count > 0) {
            //    Control c = SpBody.Panel2.Controls[0];
            //    if(c is CreateTypeControl)//是否在创建类型
            //    {
                //   CreateType();
            //    }
            //    else
            //    {
            //        ShowNote();
            //    }

            //}
            //else
            //{
                ShowNote();
         //   }
        }
        /// <summary>
        /// 现实便签控件
        /// </summary>
        private void ShowNote()
        {
            TreeNode tn = blocks.SelectedNode;

            if (tn.Level > 0)
            {
                NoteType nt = blockOper.getType(tn.Tag as NoteType);

                if (SpBody.Panel2.Controls.Count > 0) { 
                  if(SpBody.Panel2.Controls[0] is NoteViewGroup)
                    {
                        if (nt != null)
                        {
                            (SpBody.Panel2.Controls[0] as NoteViewGroup).FlushLayout(nt);//刷新布局
                            return;
                        }
                    }
                }
              
                if (nt != null)
                {
                    NoteViewGroup nvg = new NoteViewGroup(nt,blocks);
                    nvg.Dock = DockStyle.Fill;
                    nvg.Parent = this.SpBody.Panel2;
                    SetControl(nvg);
                }
            }
        }

        private void SetControl(Control c)
        {
            ClearLayou();
            this.SpBody.Panel2.Controls.Add(c);
        }

        private void expType()
        {
            TreeNode tn = blocks.SelectedNode;
            if (tn == null)
            {
                NoteMsg.Show("导出失败","请选择需要导出的节点");
                return;
            }
            if (tn.Level < 2)
            {
                NoteMsg.Show("导出失败", "无法导出根节点");
                return;
            }

            SaveFileDialog sfd = new SaveFileDialog();
            sfd.FileName = userName+ "-"+tn.Text;
            sfd.Filter = "便签节点文件|*.notenode";
            if (sfd.ShowDialog() == DialogResult.OK)
            {
               Query qu=  blockOper.ExpNoteType(tn.Tag as NoteType, sfd.FileName);
                if (qu.Querys)
                {
                   if(NoteMsg.Show("提示", "导出成功！是否移除当前节点") == DialogResult.OK)
                    {
                        DeleteType();
                    }
                }
                else
                {
                    NoteMsg.Show("提示",qu.Msg);
                }
            }
            else
            {
              
            }



            
            }
        /// <summary>
        /// 倒入节点
        /// </summary>
        private void impType()
        {
            TreeNode tn = blocks.SelectedNode;
            if (tn == null)
            {
                NoteMsg.Show("导入失败", "请选择导入时存放位置");
                return;
            }
            if (tn.Level < 1)
            {
                NoteMsg.Show("导入失败", "请选择当前选中存放位置无发存放");
                return;
            }

            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "便签节点文件|*.notenode";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
               Query qu= blockOper.ImpNoteNode(ofd.FileName, tn.Tag as NoteType);
                if(qu.Querys){
                    NoteNode n = blockOper.ImpNoteNode(ofd.FileName);
                    if(n is NoteType)
                    {
                        NoteType nt = n as NoteType;
                        (tn.Tag as NoteType).addNode(nt);
                        TreeNode tn1 = new TreeNode(nt.Title);
                        tn1.ToolTipText = nt.Reamark + "[" + nt.CreateTime.ToShortDateString() + "]";
                        tn1.Tag = n;
                        addBlockType(tn1, nt);
                        tn.Nodes.Add(tn1);
                    }
                    NoteMsg.Show("提示", "导入成功");
                }
                else
                {
                    NoteMsg.Show("提示", qu.Msg);
                }
            }

        }

        private void MoveNote()
        {
            NodeOper no = new NodeOper(blocks);
            
            no.Fun = (() =>
            {
                if (no.Isok1)
                {
                    NoteNode n = no.SelectForm.Tag as NoteNode;

                    NoteType n1 = no.SelectTo.Tag as NoteType;
                    Query qu = blockOper.MoveNoteNode(n, n1);
                    if (qu.Querys)
                    {
                        no.SelectForm.Remove();
                        no.SelectTo.Nodes.Add(no.SelectForm);
                        NoteMsg.Show("提示", "移动成功！");
                        FlushView();
                    }
                    else
                    {
                        NoteMsg.Show("提示", qu.Msg);
                    }
                }
            });
            no.Move();
        }


        /// <summary>
        /// 复制节点
        /// </summary>
        private void CopyNote()
        {
            NodeOper no = new NodeOper(blocks);

            no.Fun = (() =>
            {
                if (no.Isok1)
                {
                    NoteNode n = no.SelectForm.Tag as NoteNode;

                    NoteType n1 = no.SelectTo.Tag as NoteType;
                    Query qu = blockOper.CopyNoteNode(n, n1);
                    if (qu.Querys)
                    {
                        TreeNode tn= no.SelectForm.Clone() as TreeNode;
                        

                        no.SelectTo.Nodes.Add(tn);
                        NoteMsg.Show("提示", "复制成功！");
                        FlushView();
                    }
                    else
                    {
                        NoteMsg.Show("提示", qu.Msg);
                    }
                }
            });
            no.Move();
        }
    }
    /// <summary>
    /// 节点操作类
    /// </summary>
    class NodeOper
    {
        private TreeNode selectForm;
        private TreeNode selectTo;
        private bool Isok = false;

        private FUN fun;


        public TreeNode SelectForm
        {
            get
            {
                return selectForm;
            }

            set
            {
                selectForm = value;
            }
        }

        public TreeNode SelectTo
        {
            get
            {
                return selectTo;
            }

            set
            {
                selectTo = value;
            }
        }

        public bool Isok1
        {
            get
            {
                return selectForm!=null && selectTo!=null;
            }

            set
            {
                Isok = value;
            }
        }

        public FUN Fun
        {
            get
            {
                return fun;
            }

            set
            {
                fun = value;
            }
        }

        public NoteOper Oepr { get { return oepr; } set { oepr = value; } }

        private TreeViewEventHandler th;
       private  TreeView tv;

        private NoteOper oepr;

       public NodeOper(TreeView tv)
        {
            this.tv = tv;
            th = new TreeViewEventHandler(blocks_AfterSelect);
        }

        public void Move()
        {
        
            if (tv.SelectedNode != null)
            {
                if (tv.SelectedNode.Level > 1)
                {
                    this.SelectForm = tv.SelectedNode;
                    tv.SelectedNode.ForeColor = System.Drawing.Color.Red;
                    th = new TreeViewEventHandler(blocks_AfterSelect);
                }
                else
                {
                    NoteMsg.Show("c", "根节点选中！");
                    tv.SelectedNode.ForeColor = System.Drawing.Color.Black;
                    return;
                }
            }
           NoteMsg.Toast("提示", "请选择要移动到的节点！");
            tv.AfterSelect += th;
            
        }

        public void Copy()
        {

            if (tv.SelectedNode != null)
            {
                if (tv.SelectedNode.Level > 0)
                {
                    this.SelectForm = tv.SelectedNode;
                    tv.SelectedNode.ForeColor = System.Drawing.Color.Red;
                    //th = new EventHandler(blocks_AfterSelect);
                }
                else
                {
                    NoteMsg.Show("c", "根节点选中！");
                    tv.SelectedNode.ForeColor = System.Drawing.Color.Black;
                    return;
                }
            }
            NoteMsg.Toast("提示", "请选择要移动到的节点！");
            tv.AfterSelect += th;

        }



        public void CopyNote()
        {

            //Console.WriteLine("4 " + oepr.NowSelectNoetView);
            NoteMsg.Toast("提示", "请选择要复制到的节点！");
            tv.AfterSelect += th;

        }



        private void blocks_AfterSelect(object sender, TreeViewEventArgs e)
        {
            if (selectForm!=null)
            selectForm.ForeColor = System.Drawing.Color.Black;
            tv.AfterSelect -= th;//移除时间 
            if (tv.SelectedNode.Level >0 )
            {
                this.selectTo = tv.SelectedNode;
               // Console.WriteLine("5 " + oepr.NowSelectNoetView);
                Fun();
                //Console.WriteLine("6 " + oepr.NowSelectNoetView);
            }
            else
            {
                NoteMsg.Show("提示", "最根节点无法选中！");
                tv.SelectedNode.ForeColor = System.Drawing.Color.Black;
                return;
            }
        }
    }

    public delegate void FUN();
}
