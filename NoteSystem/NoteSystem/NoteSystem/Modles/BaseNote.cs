using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace NoteSystem.Modles
{
    /// <summary>
    /// 便签基类
    /// </summary>
    [Serializable]
    public class BaseNote:ICloneable
    {
        private DateTime createTime;//创建的时间
        private string title;//标题
        public DateTime CreateTime
        {
            get
            {
                return createTime;
            }

            set
            {
                createTime = value;
            }
        }
        public string Title
        {
            get
            {
                return title;
            }

            set
            {
                title = value;
            }
        }
        /// <summary>
        /// 构造函数，标题，时间
        /// </summary>
        /// <param name="title"></param>
        /// <param name="dt"></param>
        public BaseNote(string title,DateTime dt)
        {
            this.title = title;
            this.createTime = dt;
        }
        public BaseNote(string title)
        {
            this.title = title;
        }
        public BaseNote()
        {
         
        }

        public object Clone()
        {
            object obj = null;
            //将对象序列化成内存中的二进制流  
            BinaryFormatter inputFormatter = new BinaryFormatter();
            MemoryStream inputStream;
            inputStream = new MemoryStream();
         //   {
                inputFormatter.Serialize(inputStream, this);
            // }
            //将二进制流反序列化为对象  
            MemoryStream outputStream = new MemoryStream(inputStream.ToArray());
           
                BinaryFormatter outputFormatter = new BinaryFormatter();
                obj = outputFormatter.Deserialize(outputStream);
          

            return obj;

            // return this.MemberwiseClone();
        }
    }
}
