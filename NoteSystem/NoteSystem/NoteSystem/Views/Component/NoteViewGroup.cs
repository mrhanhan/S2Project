using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using NoteSystem.Modles.Node;
using NoteSystem.DataManage;
using NoteSystem.Views.Message;
using NoteSystem.Modles;

using System.IO;

namespace NoteSystem.Views.Component
{
    public partial class NoteViewGroup : UserControl
    {

        //闪烁解决方案
        protected override CreateParams CreateParams
        {
            get
            {
                CreateParams cp = base.CreateParams;
                cp.ExStyle |= 0x02000000;
                return cp;
            }
        }
        private void NoteViewGroup_Load(object sender, EventArgs e)
        {



            PanelBoxy.Focus();
        }
      //  bool isLoad = true;
        private void PanelBoxy_Layout(object sender, LayoutEventArgs e)
        {
           
            //    loadData();
             //调用适配视图方法
         
            PanelBoxy.Focus();
            AptView();
        }

        private void PanelBoxy_Scroll(object sender, ScrollEventArgs e)
        {
            
        }
        private void Panel_MouseWheel(object sender, MouseEventArgs e)
        {
            
        }

        private void PanelBoxy_Click(object sender, EventArgs e)
        {
            PanelBoxy.Focus();
        }
        int lastView = -1;
        private void vScrollBar1_Scroll(object sender, ScrollEventArgs e)
        {

            if (lastView != -1)
            {
                startY -= (vScrollBar1.Value - lastView);
            }
          
            lastView = vScrollBar1.Value;

            AptView();
        }

        private void BtnCreateNote_Click(object sender, EventArgs e)
        {
            CreateNewNote();//创建新的便签
        }
        
        private void tslabNoteType_Click(object sender, EventArgs e)
        {
            toolStripButton1_Click(sender, e);
        }

        private void BtnUpdateNote_Click(object sender, EventArgs e)
        {
            updateNote();
        }
        //返回文件夹
        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            clearLayout();
            loadData();
            AptView();
        }
        /// <summary>
        /// 删除界节点
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void DeleteNote_Click(object sender, EventArgs e)
        {
            deleteNote();
        }

        public void deleteNote()
        {
            if (oper.NowSelectNoetView == null)
            {
                NoteMsg.Show("提示", "请选择需要删除的节点！");
            }
            else
            {
                Note n = oper.NowSelectNoetView.Note;
                //    string userName = n.NoteBlock.Username;
                if (NoteMsg.Show("提示", "是否删除便签[" + n.Title + "]！") == DialogResult.OK)
                {
                    Query qu = oper.DeleteNote(n);
                    if (qu.Querys)
                    {
                        NoteMsg.Show("提示", "删除成功！");
                        //  NoteBlock nb = oper.getNoteBlock();
                        this.noteType = oper.getType(noteType);
                        loadData();
                    }
                    else
                    {
                        NoteMsg.Show("提示", qu.Msg);
                    }
                }
            }
        }

        private void BtnImpTxt_Click(object sender, EventArgs e)
        {
            noteEditBox.ImpText();
        }
        /// <summary>
        /// 导出Text文本
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void BtnExpTxt_Click(object sender, EventArgs e)
        {
            empTxt();
        }
        private void empTxt()
        {
         
            if (oper.NowSelectNoetView != null)
            {
                Note note = oper.getType(oper.NowSelectNoetView.Note.ParentNode).getNode(oper.NowSelectNoetView.Note.Title) as Note;
                SaveFileDialog sfd = new SaveFileDialog();
                sfd.FileName = note.NoteBlock.Username + "(" + note.Title + ")";
                sfd.Filter = "文本文件|*.*";
                if (sfd.ShowDialog() == DialogResult.OK)
                {
                    FileStream fs = null;
                    StreamWriter sw= null;
                    try
                    {
                        fs= new FileStream(sfd.FileName, FileMode.OpenOrCreate, FileAccess.ReadWrite);
                         sw = new StreamWriter(fs);
                        string txt = note.Msg.MsgText;
                    
                        string[] rows = txt.Split('\n');
                        foreach (string r in rows)
                        {
                            sw.WriteLine(r);
                        }

                    }
                    catch
                    {

                    }
                    finally
                    {
                        if (sw != null)
                        {
                            sw.Close();
                        }
                            if (fs != null)
                            {
                            fs.Close();
                            }
                        }
                }
            }
            else
            {
                NoteMsg.Show("提示","请选择需要导出的便签！");
            }
        }
        private void BtnExpNote_Click(object sender, EventArgs e)
        {
            empNote();
        }
        /// <summary>
        /// 导出节点
        /// </summary>
        private void empNote()
        {
            if (oper.NowSelectNoetView != null)
            {
                Note note = oper.NowSelectNoetView.Note;
                SaveFileDialog sfd = new SaveFileDialog();
                sfd.Filter = "便签文件|*.note";
                sfd.FileName = note.NoteBlock.Username + "[" + note.Title + "]";
                 if (sfd.ShowDialog() == DialogResult.OK)
               {
                  Query qu= oper.ExpNoteType(note, sfd.FileName);
                    if (qu.Querys)
                    {
                        NoteMsg.Show("提示","导出成功");
                    }
                    else
                    {
                        NoteMsg.Show("提示", qu.Msg);
                    }
                }
                }
                else
                {
                NoteMsg.Show("提示", "请选择需要导出的便签！");
            }
        }
        private void impNote()
        {
          
            OpenFileDialog sfd = new OpenFileDialog();
            sfd.Filter = "便签文件|*.note";
           // sfd.FileName = note.NoteBlock.Username + "[" + note.Title + "]";
            if (sfd.ShowDialog() == DialogResult.OK)
            {
               Query qu= oper.ImpNoteNode(sfd.FileName, noteType);
                if (qu.Querys)
                {
                    NoteMsg.Show("提示","导入成功！");
                    noteType = oper.getType(noteType);
                    loadData();
                    AptView();
                }
                else
                {
                    NoteMsg.Show("错误", qu.Msg);
                }
            }
        }
        private void BtnImpNote_Click(object sender, EventArgs e)
        {
            impNote();
        }
    }
}
