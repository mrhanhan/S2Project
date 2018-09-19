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
    public partial class BookInfoForm : Form
    {
        Book book;//需要修改的图书信息
        MainForm mainForm;
        BookDatabaseOption database = BookDatabaseOption.BookDatabaseOpeion;

        public BookInfoForm(MainForm mainForm,Book book)
        {
            this.book = book;
            this.mainForm = mainForm;
            InitializeComponent();
        }

        private void BookInfoForm_Load(object sender, EventArgs e)
        {
            initView();
        }
        /// <summary>
        ///初始化
        /// </summary>
        private void initView()
        {
            if (book.IsNull())
            {
                this.Text = "添加图书";
                this.button2.Text = "添加";
                //获取程序及目录
                path = AppDomain.CurrentDomain.SetupInformation.ApplicationBase+ "\\default\\Image\\defult.jpg";
               // MessageBox.Show(path);
                this.pictureBox1.Image = Image.FromFile(path);

            }
            else
            {
                this.Text = "修改图书";
                this.button2.Text = "修改";
                this.txtName.Text = book.BookName;//图书名称
                this.txtAutro.Text = book.Author;//作者
                this.txtPress.Text = book.Press;//出版社
                this.datetime.Text = book.Date;//日期
                this.numPage.Value = book.Page;
                this.numPrice.Value =decimal.Parse( book.Price.ToString());//价格
                this.txtSum.Text = book.Summary;//备注
                try
                {
                    this.pictureBox1.Image = Image.FromFile(book.ImagePath);//图片路径
                    path = book.ImagePath;
                } catch(Exception )
                {
                    this.pictureBox1.Image = Image.FromFile(path);

                }
                
            }
            ///添加类型
            List<BookType> allType = database.getAllBookTypes("");
            foreach(BookType bt in allType)
            {
                this.combType.Items.Add(bt.TypeName);
            }
            if (combType.Items.Count > 0)
            {
                combType.SelectedIndex = 0;
                button2.Enabled = true;

            }
            else
            {
                button2.Enabled = false;
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Close();
        }
        string path = "";
        private void button2_Click(object sender, EventArgs e)
        {
            string name = txtName.Text; //获取名称
            //根据名字查询类型
            BookType bt = database.getBookTypeByTypeName(combType.Text);
            int type=bt.TypeId;
            //获取作者
            string auto=txtAutro.Text;
            //获取出版社
            string press = txtPress.Text;
            //备注
            string sum = txtSum.Text;
            //获取价格
            double price =Convert.ToDouble( numPrice.Value);//获取价格
            int page = Convert.ToInt32(numPage.Value);//获取页数
            string date = Convert.ToDateTime(this.datetime.Text).ToShortDateString();//

            ///判断名字是否为空方
            if (string.IsNullOrEmpty(name.Trim()))
            {
                MessageBox.Show("图书名字不可为空");
                this.txtName.Focus();
                return;
            }
            ///判断名字是否为空方
            if (string.IsNullOrEmpty(auto.Trim()))
            {
                MessageBox.Show("作者名字不可为空");
                this.txtAutro.Focus();
                return;
            }
            ///判断名字是否为空方
            if (string.IsNullOrEmpty(name.Trim()))
            {
                MessageBox.Show("出版社名字不可为空");
                this.txtPress.Focus();
                return;
            }

            if (type == -1)
            {
                MessageBox.Show("图书类型有误！");
               
                return;
            }
            book.BookName = name;
           
            book.Author = auto;
            book.Press = press;
            book.Summary = sum;
            book.Price = price;
            book.Page = page;
            book.Date = date;
            book.ImagePath = path;

            

            if (book.IsNull())
            {
                book.BookType = new BookType(type, "", "");
                if (!database.addBook(book))
                {
                    MessageBox.Show("添加图书失败！");
                }
                else
                {
                    MessageBox.Show("添加图书成功！");
                }
                mainForm.flushView();//刷新视图
            }
            else
            {
                book.BookType = new BookType(type, "", "");
                if (!database.updateBook(book))
                {
                    MessageBox.Show("更新图书失败！");
                }
                else
                {
                    MessageBox.Show("更新图书成功！");
                }
                mainForm.flushView();//刷新视图
            }
        }

     
        /// <summary>
        /// 预览图片
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Title = "请选择图片(图片规格：7:n(n>=9))";
            ofd.Filter = "图片文件|*.bmp;*.jpg;*.jpeg;*.png";//设置打开类型
            ofd.ShowDialog();
            
            try
            {
                Image image = Image.FromFile(ofd.FileName);//获取文件路径);
                if (image.Height / (image.Width / 7) > 9)
                {
                    path = ofd.FileName;//获取文件路径
                    pictureBox1.Image = image; ;
                }
                else
                {
                    MessageBox.Show("图片宽高比：7:n  (n>9) 当前比例[7:"+ image.Height / (image.Width / 7) + "]");
                }
            }
            catch(Exception e1)
            {
                MessageBox.Show("错误："+e1.Message,"错误");
            }
        }
    }
}
