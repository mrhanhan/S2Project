using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Windows.Forms;
namespace BookManagerSystem
{
    /// <summary>
    /// 图书馆数据库操作类
    /// 单利模式
    /// </summary>
  public class BookDatabaseOption
    {

        private event Error error;
        /// <summary>
        /// 添加错误事件
        /// </summary>
        public Error AddError
        {
            set { error += value;}
        }

        /// <summary>
        /// 移除错误事件
        /// </summary>
        public Error RemoveError
        {
            set { error -= value; }
        }
        private static BookDatabaseOption bookDatabaseOpeion;
        /// <summary>
        /// 获取数据库操作类的实例
        /// </summary>
        public static BookDatabaseOption BookDatabaseOpeion
        {
            get {
                if (bookDatabaseOpeion == null) BookDatabaseOption.bookDatabaseOpeion = new BookDatabaseOption();
                return BookDatabaseOption.bookDatabaseOpeion; }
           
        }

        public List<ErrorMsg> ErrorMsg
        {
            get
            {
                return errorMsg;
            }

        }

        /// <summary>
        /// 错误信息列表
        /// </summary>
        List<ErrorMsg> errorMsg = new List<ErrorMsg>();     
        /// <summary>
        /// 数据库操作对象
        /// </summary>
        private DatabaseTools database;
        private BookDatabaseOption()
        {
            ///创建数据库对象
            database = new DatabaseTools(".","BookDB");
        }
        /// <summary>
        /// 获取所有书籍
        /// </summary>
        /// <returns></returns>
        public List<Book> getAllBooks(string where)
        {
            List<Book> allBook = new List<Book>();//创建列表
            try
            {
                DataSet ds = database.select("BookInfo", where, "*");//查询数据
                DataTable dt = ds.Tables[0];
                ///遍历表
                foreach (DataRow dr in dt.Rows)
                {
                    allBook.Add(new Book(
                          int.Parse(dr[0].ToString()),//编号
                          dr[1].ToString(),//图书名称
                          getBookTypeByTypeId(int.Parse(dr[2].ToString())),//获取图书类型
                          dr[3].ToString(),//作者
                          dr[4].ToString(),//出版社
                          dr[5].ToString(),//出版时间
                          double.Parse(dr[6].ToString()),//价格
                          int.Parse(dr[7].ToString()),//页数
                          dr[8].ToString(),//图片路径
                          dr[9].ToString()//简介
                        ));
                }
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return allBook;
        }
        /// <summary>
        /// 通过图书ID来获取指定的图书
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public Book getBookByBookId(int id)
        {
            Book b = new Book(0) ;

            try
            {

                DataSet ds = database.select("BookInfo", "bookId="+id, "*");//查询数据

                ///判断查询的是否有结果
                if (ds.Tables[0].Rows.Count > 0)
                {
                    DataRow dr = ds.Tables[0].Rows[0];
                    b = new Book(
                         int.Parse(dr[0].ToString()),//编号
                         dr[1].ToString(),//图书名称
                         getBookTypeByTypeId(int.Parse(dr[2].ToString())),//获取图书类型
                         dr[3].ToString(),//作者
                         dr[4].ToString(),//出版社
                         dr[5].ToString(),//出版时间
                         double.Parse(dr[6].ToString()),//价格
                         int.Parse(dr[7].ToString()),//页数
                         dr[8].ToString(),//图片路径
                         dr[9].ToString()//简介
                       );
                }
                
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
          

           return b;
        }
        /// <summary>
        /// 添加一本图书
        /// </summary>
        /// <param name="book"></param>
        /// <returns></returns>
        public bool updateBook(Book b)
        {
            try
            {
                if (!b.IsNull())
                {

                    int a = database.update("BookInfo","bookId="+b.BookId,
                        
                          "bookName="+SqlStr(b.BookName), SqlSet( "typeId",b.BookType.TypeId+""),
                          "author=" + SqlStr(b.Author)
                        , "press=" + SqlStr(b.Press),
                          "pubDate=" + SqlStr(b.Date),
                          "price=" + b.Price, 
                          "page="+b.Page,
                          "imagePath=" + SqlStr(b.ImagePath),
                          "summary=" + SqlStr(b.Summary));
                    return a > 0;//返回结果是否大于0
                }
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
        /// <summary>
        /// 添加图书
        /// </summary>
        /// <param name="b"></param>
        /// <returns></returns>
        public bool addBook(Book b)
        {
            try
            {
                if (!b.IsNull())
                {

                    int a = database.insert("BookInfo",  SqlStr(b.BookName), b.BookType.TypeId, SqlStr(b.Author)
                        , SqlStr(b.Press), SqlStr(b.Date), b.Price, b.Page, SqlStr(b.ImagePath), SqlStr(b.Summary));
                    return a > 0;//返回结果是否大于0
                }
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
        /// <summary>
        /// 删除指定编号的图书
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public bool deleteBook(int id)
        {
            try
            {
                int a = database.delete("BookInfo", "bookid=" + id);
                return a > 0;
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
        /// <summary>
        /// 获取指定TypeId的书记对象
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public BookType getBookTypeByTypeId(int id)
        {
            BookType bt = new BookType(-1, "", "");
            try
            {
                
                DataSet ds = database.select("BookTypeInfo", "typeId=" + id, "*");
                 
                ///判断查询的是否有结果
                if (ds.Tables[0].Rows.Count> 0)
                {
                    DataRow dr = ds.Tables[0].Rows[0];
                    bt.TypeId = int.Parse(dr[0].ToString());
                    bt.TypeName = dr[1].ToString();
                    bt.Remmark = dr[2].ToString();
                }
                return bt;
            }
            catch (Exception ex) {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return bt;

        }
         /// <summary>
        /// 获取指定TypeName的书记对象
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public BookType getBookTypeByTypeName(string name)
        {
            BookType bt = new BookType(-1, "", "");
            try
            {
                
                DataSet ds = database.select("BookTypeInfo", "typeName=" + SqlStr(name), "*");
                 
                ///判断查询的是否有结果
                if (ds.Tables[0].Rows.Count> 0)
                {
                    DataRow dr = ds.Tables[0].Rows[0];
                    bt.TypeId = int.Parse(dr[0].ToString());
                    bt.TypeName = dr[1].ToString();
                    bt.Remmark = dr[2].ToString();
                }
                return bt;
            }
            catch (Exception ex) {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return bt;

        }      
        /// <summary>
        /// 添加图书类型
        /// </summary>
        /// <param name="by"></param>
        /// <returns></returns>
        public bool addBookType(BookType by)
        {
            try
            {
               

                   int a= database.insert("BookTypeInfo", SqlStr(by.TypeName), SqlStr(by.Remmark));
                   return a > 0;//返回结果是否大于0
               
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
        /// <summary>
        /// 获取所有书本信息
        /// </summary>
        /// <returns></returns>
        public List<BookType> getAllBookTypes(string where)
        {
            List<BookType> allType = new List<BookType>();
            try
            {
                DataSet ds = database.select("BookTypeInfo", where, "*");//查询数据
                DataTable dt = ds.Tables[0];
                ///遍历表
                foreach (DataRow dr in dt.Rows)
                {
                    allType.Add(new BookType(int.Parse(dr[0].ToString()),
                                            dr[1].ToString(),dr[2].ToString()));
                }
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }

            return allType;
        }
       /// <summary>
       /// 转换为sql中的字符串
       /// </summary>
       /// <param name="s"></param>
       /// <returns></returns>
        private string SqlStr(string s)
        {
            return string.Format("'{0}'",s);
        }
        /// <summary>
        /// 更改修改图书类型
        /// </summary>
        /// <returns></returns>
        public bool updateBookType(BookType newType)
        {
            try
            {
                if (!newType.IsNull())
                {

                    int a = database.update("BookTypeInfo", "typeId=" + newType.TypeId, SqlSet("typeName",SqlStr(newType.TypeName))
                        , SqlSet("remark", SqlStr(newType.Remmark)));
                    return a > 0;//返回结果是否大于0
                }
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;

        }


        /// <summary>
        /// 删除指定编号的书籍类型
        /// </summary>
        /// <param name="typeid"></param>
        /// <returns></returns>
        public bool deleteBookType(int typeid)
        {
            try
            {
                int a = database.delete("BookTypeInfo", "typeid=" + typeid);
                return a > 0;
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
      /// <summary>
      /// 返回修改数据字符串
      /// </summary>
      /// <param name="z"></param>
      /// <param name="zd"></param>
      /// <returns>z='zd'</returns>
        private string SqlSet(string z,string zd)
        {
            return string.Format("{0}={1}",z,zd);
        }
       /// <summary>
       /// 是否存在指定条件的值
       /// </summary>
       /// <param name="but"></param>
       /// <returns></returns>
        public bool existsBook(string but)
        {
            try
            {
                DataSet ds = database.select("BookInfo", but, "*");
                return ds.Tables[0].Rows.Count > 0;
            }catch(Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }


        /// <summary>
        /// 是否存在指定条件的值
        /// </summary>
        /// <param name="but"></param>
        /// <returns></returns>
        public bool existsBookType(string but)
        {
            try
            {
                DataSet ds = database.select("BookTypeInfo", but, "*");
                return ds.Tables[0].Rows.Count > 0;
            }
            catch (Exception ex)
            {
                database.close();//关闭数据库连接
                ErrorMsg em = new ErrorMsg(DateTime.Now.ToString(), ex.Message);
                this.ErrorMsg.Add(em);
                if (error != null)
                    error(em);
            }
            return false;
        }
    }
    /// <summary>
    /// 异常事件委托
    /// </summary>
    /// <param name="em"></param>
    public delegate void Error(ErrorMsg em);
    
    
}
