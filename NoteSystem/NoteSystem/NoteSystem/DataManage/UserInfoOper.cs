using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.Modles;

namespace NoteSystem.DataManage
{
    /// <summary>
    /// 用户操作类
    /// </summary>
   public  class UserInfoOper: NoteAllData
    {
        private NoteAllData noteAllDate;//全局数据
        private ConfigSeting config;
        private int Uid = 0x88;
        public UserInfoOper()
        {
            config = ConfigSeting.Config;
        }
        /// <summary>
        /// 创建一个新的便签块
        /// </summary>
        /// <returns>返回一个新的Note</returns>
        public NoteBlock CreateNewNoteBlock(string name,string pwd)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            noteAllDate = ndfo.ReadNoteFileDate();//读取全局对象数据
            int id = Uid+ AllUser(noteAllDate).Count;//计算ID
            UserInfo userInfo = new UserInfo(name, pwd);
            DateTime d = DateTime.Now;
            userInfo.UserID = ((id+d.Month+d.Day+d.Hour+d.Minute+d.Second + d.Millisecond)^ d.Year);
            NoteBlock noteBook = new NoteBlock(name);
            noteBook.CreateTime = DateTime.Now;//设置创建时间
            noteBook.Title = name+"的便签";
            //判读便签文件是否创建成功
            if (ndfo.SaveNoteFile(userInfo.UserID + "", noteBook))
            {
                AllUser(noteAllDate).Add(name, userInfo);
                AllUserPath(noteAllDate).Add(name, id + "");
            }
          
            ///保存文件
            ndfo.SaveNoteAllDate(noteAllDate);
        
           
                return noteBook;
        }
        /// <summary>
        /// 判断是否存在用户
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public bool IsExistsUserInfo(string name)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            noteAllDate = ndfo.ReadNoteFileDate();//读取全局对象数据

            return AllUser(noteAllDate).ContainsKey(name);
        }
        /// <summary>
        /// 获取用户数据
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public UserInfo getUserInfo(string name)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            noteAllDate = ndfo.ReadNoteFileDate();//读取全局对象数据
            UserInfo ui = null;
            try {
                 ui = AllUser(noteAllDate)[name];
            }
            catch
            {
               
            }
            ///保存文件
            ndfo.SaveNoteAllDate(noteAllDate);
            return ui;
        }
        /// <summary>
        /// 获取用户便签所对应的问价名称
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public string getUserBlockPath(UserInfo user)
        {
            return user.UserID + "";
        }
        /// <summary>
        /// 删除一个用户
        /// </summary>
        /// <returns></returns>
        public bool deleteUserInfo(string name)
        {
            try {
                NoteDateFileOper ndfo = new NoteDateFileOper();
                noteAllDate = ndfo.ReadNoteFileDate();//读取全局对象数据
                UserInfo u = AllUser(noteAllDate)[name];
                ///移除用户
                bool a = AllUser(noteAllDate).Remove(name);
                //如果移除成功删除便签
                if ( u != null)
                {
                    ndfo.DeleteBlokc(u.UserID + "");
                }

                ///保存文件
                ndfo.SaveNoteAllDate(noteAllDate);
                return a;
            }
            catch
            {
                return false;
            }
        } 
        /// <summary>
        /// 获取指定用户名所对应的便签
        /// </summary>
        /// <param name="userName"></param>
        /// <returns></returns>
        public NoteBlock getNoteBlock(string userName)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            //判断是否存在这个用户
            if (!IsExistsUserInfo(userName))
            {
                return null;
            }
            return ndfo.ReadNoteFile(getUserInfo(userName).UserID+"");
        }

        /// <summary>
        /// 刷新文件
        /// </summary>
        public void flushFile(NoteAllData nad=null)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            ///保存文件
            ndfo.SaveNoteAllDate(nad==null?noteAllDate:nad);
        }
    }
}
