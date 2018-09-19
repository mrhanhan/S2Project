using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using NoteSystem.DataManage;
using NoteSystem.Modles;

namespace NoteSystem.Views
{
    public partial class RegForm : BaseNoteForm
    {

        public RegForm()
        {
            InitializeComponent();
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
                error.SetError(txtName,"名称不能为空");
                return;
            }
            else
            {
                error.SetError(txtName,"");
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


           

            UserInfoOper uio = new UserInfoOper();

            if (uio.IsExistsUserInfo(name))
            {
                error.SetError(txtName, "名称重复");
               
                return;
            }
            else
            {
                error.SetError(txtName, "");
            }
            //创建用户
            NoteBlock nb= uio.CreateNewNoteBlock(name, pwd);

            UserInfo userinfo =uio.getUserInfo(name);
            if(nb==null || userinfo == null)
            {
                MessageBox.Show("注册失败");
                //判断是否存在
                if (uio.IsExistsUserInfo(name))
                {
                    uio.deleteUserInfo(name);
                }
                return;
            }
            try {
                ///设置头像
                userinfo.HeadImg = img;
                userinfo.Slogan = gy;
                userinfo.Sex = sex;
                userinfo.Slogan = gy;
                userinfo.Age = age;
                uio.flushFile();//刷新文件
                txtName.Text = "";
                txtPwd.Text = "";
                txtGY.Text = "";

                MessageBox.Show("注册成功","提示");

            }
            catch
            {
                //判断是否存在
                if (uio.IsExistsUserInfo(name))
                {
                    uio.deleteUserInfo(name);
                }
                MessageBox.Show("注册失败","提示");
            }


        }

        private void RegForm_Load(object sender, EventArgs e)
        {
            this.cmbSex.SelectedIndex = 0;
            this.IsFixed = true;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {

        }
    }
}
