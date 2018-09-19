using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagerSystem
{
   public struct BookType
    {
        private int typeId;//图书类型编号
        /// <summary>
        /// 设置获取图书编号
        /// </summary>
        public int TypeId
        {
            get { return typeId; }
            set { typeId = value; }
        }
        //图书类型名称
        private string typeName;
        /// <summary>
        /// 设置获取图书类型名称
        /// </summary>
        public string TypeName
        {
            get { return typeName; }
            set { typeName = value; }
        }
        private string remmark;//图书类型备注
        /// <summary>
        /// 设置获取图书类型备注
        /// </summary>
        public string Remmark
        {
            get { return remmark; }
            set { remmark = value; }
        }
        /// <summary>
        /// 图书类型类构造函数
        /// </summary>
        /// <param name="id">类型ID</param>
        /// <param name="name">类型名称</param>
        /// <param name="rmk">类型备注</param>
        public BookType(int id,string name,string rmk)
        {
            this.typeId = id;
            this.typeName = name;
            this.remmark = rmk;
        }
        /// <summary>
        /// 是否是空
        /// </summary>
        /// <returns></returns>
        public bool IsNull()
        {
            return (typeId < 0);
        }

        public BookType(int a=-1){
            this.typeId = -1;
            this.typeName = "";
            this.remmark = "";
        }
    }
}
