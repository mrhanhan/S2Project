using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoteSystem.Modles
{
    /// <summary>
    /// 对便签所有数据的操作类
    /// </summary>
    /// 
    [Serializable]
   public  class NoteAllData
    { 
        /// <summary>
        /// 构造函数
        /// </summary>
        protected NoteAllData()
        {
            allUser = new Dictionary<string, UserInfo>();
            allUserPath = new Dictionary<string, string>();
        }
        /// <summary>
        /// 创建新的全局数据
        /// </summary>
        /// <returns></returns>
        public static NoteAllData createNewNoteAllDate()
        {
            return new NoteAllData();
        }
        /// <summary>
        /// 用户信息
        /// </summary>
        private Dictionary<string, UserInfo> allUser ;
        /// <summary>
        /// 用户信息对应的文件的路径
        /// </summary>
        private Dictionary<string, string> allUserPath ;
        /// <summary>
        /// 获取指定数据的所有是用户
        /// </summary>
        /// <param name="nd"></param>
        /// <returns></returns>
        protected Dictionary<string, UserInfo> AllUser(NoteAllData nd)
        {
            if(nd!=null)
            return nd.allUser;
            return null;
           
        }
        /// <summary>
        /// 获取指定用户的所有路径
        /// </summary>
        /// <param name="nd"></param>
        /// <returns></returns>
        protected Dictionary<string, string> AllUserPath(NoteAllData nd)
        {
            
            if (nd != null)
                return nd.allUserPath;
            return null;
        }

     
    }
}
