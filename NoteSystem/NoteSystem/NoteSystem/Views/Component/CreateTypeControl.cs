using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using NoteSystem.Modles;
using NoteSystem.DataManage;
namespace NoteSystem.Views.Component
{
    public partial class CreateTypeControl : BaseNoteControl
    {
        private TreeNode treenNode;
        private NoteBlockOper oper;
        private NoteType type;
        public CreateTypeControl(TreeNode tn,NoteBlockOper oper)
        {
            InitializeComponent();
            this.oper = oper;
            this.treenNode = tn;
            this.type = tn.Tag as NoteType;
            this.txtTitle.Text = type.Title;
            this.txtRemark.Text = type.Reamark;
        }
        /// <summary>
        /// 刷新数据
        /// </summary>
        /// <param name="tn"></param>
        /// <param name="oper"></param>
        public void FlushData(TreeNode tn, NoteBlockOper oper)
        {
            this.oper = oper;
            this.treenNode = tn;
            this.type = tn.Tag as NoteType;
            this.txtTitle.Text = type.Title;
            this.txtRemark.Text = type.Reamark;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            update();
        }
        /// <summary>
        /// 添加便签
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            Create();

        }

        private void Create()
        {
            string name = txtTitle.Text.Trim();
            string rmk = txtRemark.Text.Trim();
            if (string.IsNullOrEmpty(name))
            {
                Message.NoteMsg.Show("提示", "请输入标题！");
                return;
            }
            NoteType nt = new NoteType(name, rmk);
            NoteType n1 = new NoteType(name, rmk);
            TreeNode tn = new TreeNode(name);
            tn.ToolTipText =nt.Reamark+"["+nt.CreateTime.ToShortDateString()+"]";
            tn.Tag = nt;
            n1.ParentNode = type;
            Query qu = oper.AddNoteType(type, nt);
            if (qu.Querys)
            {
                treenNode.Nodes.Add(tn);
                Message.NoteMsg.Show("错误", "创建成功");
            }
            else
            {
                Message.NoteMsg.Show("错误", "创建失败：" + qu.Msg);
            }
        }



        private void update()
        {
            string name = txtTitle.Text.Trim();
            string rmk = txtRemark.Text.Trim();

            if (treenNode.Level < 2)
            {
                Message.NoteMsg.Show("提示", "无法修改根节点！");
                return;
            }

            if (string.IsNullOrEmpty(name))
            {
                Message.NoteMsg.Show("提示", "请输入标题！");
                return;
            }

          
            NoteType nt = treenNode.Tag as NoteType;
            NoteType n1 = new NoteType(name, rmk);


            Query qu=oper.UpdateNoteType(nt, n1);

            if (qu.Querys)
            {
                treenNode.Tag = n1;
                treenNode.Text = n1.Title;
                treenNode.ToolTipText = n1.Reamark+"["+nt.CreateTime.ToShortDateString()+"]";
                Message.NoteMsg.Show("提示","修改成功");
            }
            else
            {
                Message.NoteMsg.Show("错误", qu.Msg);
            }


        }
    }
}
