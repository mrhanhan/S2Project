using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NoteSystem
{
    public partial class Login :BaseNoteForm
    {
        public Login()
        {
            InitializeComponent(); 
        }

        private void Login_Load(object sender, EventArgs e)
        {
            ConfigSeting cs= ConfigSeting.Config;
            this.IsFixed = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string name = txtName.Text.Trim();
            string pwd = txtPwd.Text.Trim();
            DataManage.UserInfoOper uio = new DataManage.UserInfoOper();
            if (uio.IsExistsUserInfo(name))
            {
                Modles.UserInfo user = uio.getUserInfo(name);
                if (user != null)
                {
                    if (user.UserPwd.Equals(pwd))
                    {
                      new NoteSystem.Views.MainForm(name).Show();
                        this.Hide();
                    }
                    else
                    {
                        MessageBox.Show("密码错误！", "提示");
                    }
                }
                else
                {
                    MessageBox.Show("不存在此用户！", "提示");
                }

            }
            else
            {
                MessageBox.Show("不存在此用户！","提示");
            }
        }

        /// <summary>
        /// 注册按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button2_Click(object sender, EventArgs e)
        {
         new Views.RegForm().Show();
        }
    }
}
