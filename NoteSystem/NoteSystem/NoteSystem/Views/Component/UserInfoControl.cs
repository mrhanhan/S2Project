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
    public partial class UserInfoControl : UserControl
    {
        string userinfo;
        UserInfoOper oper;
        MainForm mf;

        public UserInfoControl(string username,UserInfoOper oper,MainForm mf)
        {
            this.userinfo = username;
            this.oper = oper;
            this.mf = mf;
            InitializeComponent();
        }

        private void UserInfoControl_Load(object sender, EventArgs e)
        {
            UserInfo ui = oper.getUserInfo(userinfo);
            txtName.Text = ui.UserNamr;
            txtPwd.Text = ui.UserPwd;
            txtGY.Text = ui.Slogan;
            numAge.Value = ui.Age;
            cmbSex.Text = ui.Sex;
            picPhoto.Image = ui.HeadImg;
            cmbSex.SelectedIndex = ui.Sex=="男"?0:1;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string name = txtName.Text.Trim();
            string pwd = txtPwd.Text.Trim();
            int age = Convert.ToInt32(numAge.Value);
            string sex = cmbSex.Text;
            string gy = txtGY.Text;
            Image img = picPhoto.Image;
            if (string.IsNullOrEmpty(name))
            {
                error.SetError(txtName, "名称不能为空");
                return;
            }
            else
            {
                error.SetError(txtName, "");
            }
            if (string.IsNullOrEmpty(pwd))
            {
                error.SetError(txtPwd, "密码不能为空");
                return;
            }
            else
            {
                error.SetError(txtPwd, "");
            }
            if (img == null)
            {
                error.SetError(picPhoto, "请选择头像");
                return;
            }
            else
            {

                error.SetError(picPhoto, "");
            }

            UserInfo ui = oper.getUserInfo(userinfo);
          
            ui.UserPwd=pwd;
            ui.Slogan=gy;
             ui.Age=Convert.ToInt32(numAge.Value);
           ui.Sex = cmbSex.Text;
           ui.HeadImg = picPhoto.Image;

            oper.flushFile();
            mf.FlushView();
            NoteMsg.Show("提示","修改成功");
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {

        }

        private void linkLabel1_Click(object sender, EventArgs e)
        {
            
                OpenFileDialog openfile = new OpenFileDialog();
                openfile.Filter = "图片文件(.jpg)|*.jpg|图片文件(.jpge)|*.jpge|图片文件(.png)|*.png|图片文件(.bmp)|*.bmp";
                if (openfile.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        picPhoto.Image = Image.FromFile(openfile.FileName);
                    }
                    catch
                    {

                    }
                
            }
        }
    }
}
