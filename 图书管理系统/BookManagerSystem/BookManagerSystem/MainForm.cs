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
    public partial class MainForm : Form
    {
        BookDatabaseOption bookOpeion = BookDatabaseOption.BookDatabaseOpeion;
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            initView();
            bookOpeion.AddError = (ErrorMsg em) => { this.Text = em.ErrorMessage; };
            this.toolStripComboBox1.SelectedIndex = 0;
            initList();
        }
        /// <summary>
        /// 初始化视图
        /// </summary>
        private void initView()
        {
            List<BookType> allType = bookOpeion.getAllBookTypes("");
            treeAllType.Nodes.Clear();//清除根节点
            TreeNode rootItem = new TreeNode("图书信息");
            rootItem.ToolTipText = "图书信息";
            treeAllType.Nodes.Add(rootItem);
            BookType tb = new BookType();
            foreach (BookType bt in allType)
            {
                //创建子节点
                TreeNode item1 = new TreeNode(bt.TypeName);
                ///设置提示信息
                item1.ToolTipText = item1.ToolTipText = bt.Remmark;

                rootItem.Nodes.Add(item1);
                tb = bt;

            }


            if (!tb.IsNull())
            {
                //获取指定类型编号的图书
                List<Book> allBook = bookOpeion.getAllBooks("typeid=" + tb.TypeId);
                this.maxImage.Images.Clear();
                this.listAllBookInfo.Items.Clear();
                foreach (Book b in allBook)
                {
                    ListViewItem lvi = new ListViewItem(b.BookId + "");

                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookType.TypeName));

                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookName));
                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Author));
                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Press));
                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Date));
                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Price.ToString()));
                    lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Page.ToString()));
                    this.listAllBookInfo.Items.Add(lvi);
                    try
                    {
                        //添加图片
                        maxImage.Images.Add(Image.FromFile(b.ImagePath));
                        //获取最后下标位置
                        lvi.ImageIndex = maxImage.Images.Count - 1;//设置
                    }
                    catch { }
                }
            }


        }
        private void initList()
        {

            //获取指定类型编号的图书
            List<Book> allBook = bookOpeion.getAllBooks("");
            this.maxImage.Images.Clear();
            this.listAllBookInfo.Items.Clear();
            foreach (Book b in allBook)
            {
                ListViewItem lvi = new ListViewItem(b.BookId + "");

                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookType.TypeName));

                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookName));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Author));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Press));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Date));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Price.ToString()));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Page.ToString()));
                this.listAllBookInfo.Items.Add(lvi);
                try
                {
                    //添加图片
                    maxImage.Images.Add(Image.FromFile(b.ImagePath));
                    //获取最后下标位置
                    lvi.ImageIndex = maxImage.Images.Count - 1;//设置
                }
                catch { }
            }

        }
        private void treeAllType_AfterSelect(object sender, TreeViewEventArgs e)
        {
            treeAllType_Click(null, null);
        }

        private void treeAllType_Click(object sender, EventArgs e)
        {
            TreeNode by = treeAllType.SelectedNode;//获取选中的Node节点
            if (by == null)
            {
                return;
            }
            //判断级别
            if (by.Level == 0)
            {

                return;
            }

            //获取BookType 
            BookType bt = bookOpeion.getBookTypeByTypeName(by.Text);
            //获取指定类型编号的图书
            List<Book> allBook = bookOpeion.getAllBooks("typeid=" + bt.TypeId);
            this.maxImage.Images.Clear();
            this.listAllBookInfo.Items.Clear();
            foreach (Book b in allBook)
            {
                ListViewItem lvi = new ListViewItem(b.BookId + "");

                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookType.TypeName));

                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.BookName));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Author));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Press));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Date));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Price.ToString()));
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, b.Page.ToString()));
                this.listAllBookInfo.Items.Add(lvi);
                try
                {
                    maxImage.Images.Add(Image.FromFile(b.ImagePath));
                    lvi.ImageIndex = maxImage.Images.Count - 1;//设置
                }
                catch { }
            }
        }
        /// <summary>
        /// 大小改变是调用
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void listAllBookInfo_Resize(object sender, EventArgs e)
        {
            int width = listAllBookInfo.Width;
            int sw = width / 8;//平均

            foreach (ColumnHeader ch in listAllBookInfo.Columns)
            {
                ch.Width = sw;
            }
        }

        private void listAllBookInfo_Click(object sender, EventArgs e)
        {
            listAllBookInfo_SelectedIndexChanged(null, null);
        }

        private void listAllBookInfo_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (listAllBookInfo.SelectedItems.Count > 0)
            {
                ///获取被选中的行
                ListViewItem lvi = listAllBookInfo.SelectedItems[0];
                if (lvi != null)
                {
                    int id = int.Parse(lvi.Text.ToString());
                    Book b = bookOpeion.getBookByBookId(id);
                    this.textBox1.Text ="图书简介：\r\n"+ b.Summary;
                    try
                    {
                        this.photo.Image = Image.FromFile(b.ImagePath);
                    }
                    catch { }
                }
            }
        }

        private void delete()
        {
            TreeNode tn = this.treeAllType.SelectedNode;
            if (tn == null)
            {
                MessageBox.Show("请选择需要删除的类型！");
                return;
            }
            if (tn.Level == 0)
            {
                //根节点无法删除
                MessageBox.Show("根节点无法删除");
                return;
            }


            //获取booktype
            BookType bt = bookOpeion.getBookTypeByTypeName(tn.Text);
            ///判断当书籍类型是否被外键引用者
            if (bookOpeion.existsBook("typeid=" + bt.TypeId))
            {
                if (MessageBox.Show("当前书籍类型下，存在着书籍！是否继续删除（继续删除则会删除当前书籍类型下所有书籍）？", "提示", MessageBoxButtons.OKCancel) == DialogResult.OK)
                {
                    List<Book> alldelBook = bookOpeion.getAllBooks("typeid=" + bt.TypeId);
                    foreach (Book b in alldelBook)
                        bookOpeion.deleteBook(b.BookId);
                }
                else
                    return;
            }
            if (!bookOpeion.deleteBookType(bt.TypeId))
            {
                MessageBox.Show("删除失败");
            }
            flushView();
        }

        /// <summary>
        /// 
        /// </summary>AAAA aaa
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void toolStripComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string select = toolStripComboBox1.Text;
            switch (select)
            {
                case "详细信息":
                    listAllBookInfo.View = View.Details;
                    break;
                case "平铺":
                    listAllBookInfo.View = View.Tile;
                    break;
                case "大图标":
                    listAllBookInfo.View = View.LargeIcon;
                    break;
            }
        }

        /// <summary>
        /// 刷新视图
        /// </summary>
        public void flushView()
        {
            TreeNode tn = treeAllType.SelectedNode;
            initView();
            treeAllType.ExpandAll();
            if (tn != null)
            {
                treeAllType.SelectedImageIndex = tn.Index;
            }

        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            new AddBookTypeForm(this, new BookType(0)).Show();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            TreeNode tn = this.treeAllType.SelectedNode;
            if (tn == null)
            {
                MessageBox.Show("请选择类型！");
                return;
            }
            if (tn.Level == 0)
            {
                MessageBox.Show("无法修改根节点");
                return;
            }
            BookType ty = bookOpeion.getBookTypeByTypeName(tn.Text);
            new AddBookTypeForm(this, ty).Show();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            delete();
        }

        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            if (listAllBookInfo.SelectedItems.Count > 0)
            {
                ListViewItem lvi = listAllBookInfo.SelectedItems[0];
                if (MessageBox.Show("确认删除图书：" + lvi.SubItems[2].Text, "提示", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    bool jg = bookOpeion.deleteBook(int.Parse(lvi.Text));//删除书记
                    if (!jg)
                    {
                        MessageBox.Show("删除失败！");
                    }
                    flushView();
                }
                else
                {
                    MessageBox.Show("请选择需要删除的图书！");
                }
            }
        }

        private void toolStripButton5_Click(object sender, EventArgs e)
        {
            if (listAllBookInfo.SelectedItems.Count > 0)
            {
                ListViewItem lvi = listAllBookInfo.SelectedItems[0];
                Book b = bookOpeion.getBookByBookId(int.Parse(lvi.Text));
                new BookInfoForm(this, b).Show();
            }
            else
            {
                MessageBox.Show("请选择需要修改的图书！");
            }
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            new BookInfoForm(this,new Book(0)).Show();
        }

        private void 编辑EToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void 隐藏ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
        }

        private void 最小化ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Normal;
        }

        private void 最大化ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;
        }

        private void 退出EToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ErrorForm().Show();
        }

        private void toolStripComboBox1_Click(object sender, EventArgs e)
        {

        }
    }
 }
