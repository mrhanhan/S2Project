using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using NoteSystem.Views.Message;
using NoteSystem.Modles;

namespace NoteSystem.Views
{
    public partial class MainForm : BaseNoteForm
    {

        private bool isExit = true;

        protected override CreateParams CreateParams
        {
            get
            {
                CreateParams cp = base.CreateParams;
                cp.ExStyle |= 0x02000000;
                return cp;
            }
        }

        private void closebtn_Click_1(object sender, EventArgs e)
        {
         
            Application.Exit();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            LodaView();
        }
        /// <summary>
        /// 下拉框
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void labSelect_Click(object sender, EventArgs e)
        {
            
           
                labSelect.Text = "∧";
                //显示下拉列表
                labSelect.ContextMenuStrip.Show(
                    new Point(
                        this.Location.X+labSelect.Location.X,
                        this.Location.Y + labSelect.Location.Y+ labSelect.Height));
         
        }

        private void selectMenu_Click(object sender, EventArgs e)
        {
            labSelect.Text = "∨";
        }

        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            Application.Exit();
        }
        /// <summary>
        /// 检查任务
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Task_JC_Tick(object sender, EventArgs e)
        {
            if (!labSelect.ContextMenuStrip.Visible )
            {
                labSelect.Text = "∨";

            }
            
        }

        private void tsBtnCreateType_Click(object sender, EventArgs e)
        {
            CreateType();
        }
        /// <summary>
        /// 设置按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSeting_Click(object sender, EventArgs e)
        {
            btnSeting.ContextMenuStrip.Show(new Point(this.Location.X+btnSeting.Location.X, this.Location.Y+btnSeting.Location.Y+btnSeting.Height));
        }

        private void blocks_AfterSelect(object sender, TreeViewEventArgs e)
        {
            BlockSelect();
        }

        private void 注销ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            new Login().Show();
            this.Hide();
        }

        private void 注销并最小化ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Bitmap b = new Bitmap(picUserHeadImg.Image);
            Icon i = Icon.FromHandle(b.GetHicon());//Bitmap转换为Icon
            notifyIcon1.Icon = i;
            notifyIcon1.Text = userName;
            this.ShowInTaskbar = false;
            this.Hide();
        }

        private void notifyIcon1_DoubleClick(object sender, EventArgs e)
        {
            this.Show();
        }

        private void 打开ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Show();
            notifyIcon1.Icon = null;
            this.ShowInTaskbar = true;
        }

        private void 注销ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new Login().Show();
            isExit = false;
            this.Close();
            
        }

        private void 退出ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void tsBtnDelType_Click(object sender, EventArgs e)
        {
            DeleteType();
        }

        private void tsBtnExpType_Click(object sender, EventArgs e)
        {
            expType();
        }

        private void 导出类型ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            expType();
        }

        private void 倒入类型ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            impType();
        }

        private void tsBtnImpType_Click(object sender, EventArgs e)
        {
            impType();
        }

        private void 移动类型ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MoveNote();
        }

        private void 复制类型ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CopyNote();
        }

        private void 格式化所有ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            if (NoteMsg.Show("警告", "是否确认格式化！确认后无法恢复") == DialogResult.OK)
            {
                blockOper.ClearAll();
                InitView();
            }
        }

        private void 刷新ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            InitView();
        }

        private void 现实便签ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TreeNode tn = blocks.SelectedNode;
            if (tn.Level > 0)
            {
                if (NoteMsg.Show("警告", "是否删除当前类型下所有文件！") == DialogResult.OK)
                {
                    blockOper.ClearAll(tn.Tag as NoteType);
                    BlockSelect();
                }
            }
        }

        private void 创建便签ToolStripMenuItem_Click(object sender, EventArgs e)
        {
           
        }

        private void 啊ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void notifyIcon1_MouseDoubleClick(object sender, MouseEventArgs e)
        {
          InputQuery iq= InputMsg.Show("提示","请输入用户："+userName+"的登陆密码");
            if (iq.Dr == DialogResult.OK)
            {
                if (oper.getUserInfo(userName).UserPwd.Equals(iq.InputMsg))
                {
                    this.Show();
                }
                else
                {
                    NoteMsg.Show("警告","密码错误");
                     this.Hide();
                }
            }
            else
            {
                this.Hide();
            }
        }

        private void 用户信息ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            showUserInfo();
        }
    }
}
