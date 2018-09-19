using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagerSystem
{
    /// <summary>
    /// 图书类
    /// </summary>
   public struct Book
    {
        private int bookId;//图书ID
        /// <summary>
        /// 设置获取图书ID
        /// </summary>
        public int BookId
        {
            get { return bookId; }
            set { bookId = value; }
        }
        private BookType bookType;//图书类型
        /// <summary>
        /// 设置获取图书类型
        /// </summary>
        internal BookType BookType
        {
            get { return bookType; }
            set { bookType = value; }
        }
        private string bookName;//图书名称
        /// <summary>
        /// 设置获取图书名称
        /// </summary>
        public string BookName
        {
            get { return bookName; }
            set { bookName = value; }
        }
        /// <summary>
        /// 作者
        /// </summary>
        private string author;
        /// <summary>
        /// 设置获取图书的作者
        /// </summary>
        public string Author
        {
            get { return author; }
            set { author = value; }
        }
        /// <summary>
        /// 图书出版社
        /// </summary>
        private string press;
        /// <summary>
        /// 设置获取图书出版社
        /// </summary>
        public string Press
        {
            get { return press; }
            set { press = value; }
        }
        ///出版日期
        private string date;
        /// <summary>
        /// 设置获取出版日期
        /// </summary>
        public string Date
        {
            get { return date; }
            set { date = value; }
        }
        /// <summary>
        /// 图书价格
        /// </summary>
        private double price;
        /// <summary>
        /// 设置获取图书价格
        /// </summary>
        public double Price
        {
            get { return price; }
            set { price = value; }
        }
        //图书页数
        private int page;
        /// <summary>
        /// 设置获取图书页数
        /// </summary>
        public int Page
        {
            get { return page; }
            set { page = value; }
        }
        //图书封面图片路径
        private string imagePath;
        /// <summary>
        /// 设置获取图书封面图片路径
        /// </summary>
        public string ImagePath
        {
            get { return imagePath; }
            set { imagePath = value; }
        }
        //简介
        private string summary;
        /// <summary>
        /// 设置获取图书简介
        /// </summary>
        public string Summary
        {
            get { return summary; }
            set { summary = value; }
        }
        /// <summary>
        /// 图书类构造函数
        /// </summary>
        /// <param name="id"></param>
        /// <param name="bookName"></param>
        /// <param name="type"></param>
        /// <param name="author"></param>
        /// <param name="press"></param>
        /// <param name="date"></param>
        /// <param name="price"></param>
        /// <param name="page"></param>
        /// <param name="image"></param>
        /// <param name="sum"></param>
        public Book(int id,string bookName,BookType type,string author,string press,string date,double price,int page ,string image,string sum)
        {
            this.bookId = id;
            this.bookName = bookName;
            this.bookType = type;
            this.author = author;
            this.press = press;
            this.date = date;
            this.price = price;
            this.page = page;
            this.imagePath = image;
            this.summary = sum;
        }
        /// <summary>
        /// 是否为空
        /// </summary>
        /// <returns></returns>
        public bool IsNull()
        {
            return bookId < 0 && bookType.TypeId<0;
        }

        public Book(int a=0)
        {
            this.bookId = -1;
            this.bookName = "";
            this.bookType = new BookType(0);
            this.author = "";
            this.press = "";
            this.date = "";
            this.price = 0;
            this.page = 0;
            this.imagePath = "";
            this.summary = "";
        }
    }
}
