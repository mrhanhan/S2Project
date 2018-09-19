using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BookManagerSystem
{
    public partial class AddBookTypeForm : Form
    {
        BookType udbook;//需要修改的BookTyp
        MainForm mainForm;//主窗体对象
        BookDatabaseOption bookOprion=BookDatabaseOption.BookDatabaseOpeion;//图书操作
        public AddBookTypeForm(MainForm mainForm, BookType bt)
        {
            InitializeComponent();
            this.mainForm = mainForm;
            this.udbook = bt;
        }

       

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (textBox1.Text==""|| bookOprion.existsBookType("typeName='"+this.textBox1.Text+"'"))
            {
                this.nameError.Text ="类型名已存在或者为空";
                this.nameError.ForeColor = Color.Red;
                this.button1.Enabled = false;
            }
            else
            {
                this.button1.Enabled = true;
                this.nameError.Text = "";
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AddBookTypeForm_Load(object sender, EventArgs e)
        {
            if (!udbook.IsNull())
            {
                this.Text = "修改图书类型";
                this.button1.Text = "修改";
                this.textBox1.Text = udbook.TypeName;
                this.textBox2.Text = udbook.Remmark;
            }
           
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            if (this.Text.Length >= 100)
            {
                MessageBox.Show("简介内容长度最大为100个汉子字符");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            udbook.Remmark = textBox2.Text;
            udbook.TypeName = textBox1.Text.Trim();
            
            if (udbook.IsNull())
            {

                udbook.TypeId = 0;
                if (!bookOprion.addBookType(udbook))
                {
                    MessageBox.Show("添加失败！请查看错误信息窗口！");
                }
                else
                {
                    MessageBox.Show("添加成功！");
                    this.textBox1.Text = "";
                    this.textBox2.Text = "";
                }
            }
            else
            {
                if (!bookOprion.updateBookType(udbook))
                {
                    MessageBox.Show("修改失败！请查看错误信息窗口！");
                }
                else
                {
                    MessageBox.Show("修改成功！");
                    this.textBox1.Text = "";
                    this.textBox2.Text = "";
                }
            }
            mainForm.flushView();//刷新视图
        }
    }
}
