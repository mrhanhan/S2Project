using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;
namespace BookManagerSystem
{
    class DatabaseTools
    {
        private SqlConnection sqlconn;
        public DatabaseTools(string servername,string dbName)
        {
            string cons = string.Format("server={0};database={1};uid=sa;pwd=123456",servername,dbName);
            sqlconn = new SqlConnection(cons);//创建数据库对象
        }
        private void open()
        {
            if (!(sqlconn.State == ConnectionState.Open))
            {
                sqlconn.Open();
            }
        }

        /// <summary>
        /// 插入数
        /// </summary>
        /// <param name="tbname"></param>
        /// <param name="vs"></param>
        /// <returns>返回插入数据的行数</returns>
        public int insert(string tbname, params object[] vs)
        {
            open();
            string sql = "insert into "+tbname+" Values(";
            foreach (object a in vs)
            {
                sql += (a + ",");
            }
            sql = sql.Substring(0, sql.Length - 1);
            sql += ")";
            SqlCommand sqlCommand = new SqlCommand(sql, sqlconn);
            int b = sqlCommand.ExecuteNonQuery();
            close();
            return b;
        }

        public int update(string tbName, string where, params object[] updata)
        {
            open();
            int b;
            string sql = "update " + tbName + " set ";
            foreach (object a in updata)
            {
                sql += (a + ",");
            }
            sql = sql.Substring(0,sql.Length-1);
            if(where!=""){

                sql += " where " + where;            }
            b = new SqlCommand(sql, sqlconn).ExecuteNonQuery();
            close();
            return b;
        }
        public DataSet select(string tbname, string where, string zd)
        {
            open();
            string sql = "select " + zd + " from " + tbname;
            if (where != "")
            {
                sql += " where " + where;
            }
            DataSet ds = new DataSet();
            new SqlDataAdapter(sql, sqlconn).Fill(ds);
            close();
            return ds;
        }
        public void close()
        {
            if (!(sqlconn.State == ConnectionState.Closed))
            {
                sqlconn.Close();
            }
        }
        public int delete(string tbn,string where)
        {
            open();
            string sql = "delete  " + tbn;
            if (where != "")
            {
                sql += " where " + where;
            }
           int b= new SqlCommand(sql, sqlconn).ExecuteNonQuery();
            close();
            return b;
        }
    }
}
