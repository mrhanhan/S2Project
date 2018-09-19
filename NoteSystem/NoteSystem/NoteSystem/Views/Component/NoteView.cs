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

namespace NoteSystem.Views.Component
{
    public partial class NoteView : UserControl
    {
        private Note note;//便签信息
        NoteOper oper;

        public Note Note
        {
            get
            {
                return note;
            }

        }

        internal NoteView(Note note,NoteOper oper)
        {
        
            this.note = note;
            this.oper = oper;
            InitializeComponent();
            if (note != null)
            {
                dataBindView();
            }
        }

        private void dataBindView()
        {
            this.noteName.Text = Note.Title;
            this.noteUser.Text = Note.NoteBlock.Username;
            this.txtRMK.Text = Note.ParentNode.Reamark;
            this.time.Text = Note.CreateTime.ToString();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            oper.DeleteNote(this);//删除Note
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "便签文件|*.note";
            sfd.FileName = Note.NoteBlock.Username + "[" + Note.Title + "]";
            if (sfd.ShowDialog()==DialogResult.OK) { 
            oper.ExpNoteType(Note,sfd.FileName);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            oper.EditNote(this);
        }

        private void noteName_Click(object sender, EventArgs e)
        {
            oper.NowSelectNoetView = this;
        }

        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            oper.NowSelectNoetView = this;
            oper.ViewDelete();
        }

        private void 编辑ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            oper.EditNote(this);
        }

        private void 创建新的ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            oper.ViewCreate();
        }

        private void 复制ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            oper.NowSelectNoetView = this;
            oper.ViewCopy();
        }

        private void 移动ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            oper.NowSelectNoetView = this;
            oper.ViewMove();        }

        private void 重命名ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            InputQuery qi = InputMsg.Show("提示", "请输入新的名称");
            if (qi.Dr == DialogResult.OK)
            {
                if (oper.Exists(note.ParentNode, qi.InputMsg))
                {
                    NoteMsg.Show("错误", "名字已经重复");
                    return;
                }
                if (!oper.Rename(qi.InputMsg, note))
                    NoteMsg.Show("错误", "修改失败");
                else
                {
                    this.note.Title = qi.InputMsg;
                    dataBindView();
                }
            }
        }
    }
}
