using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace NoteSystem.Modles
{
    [Serializable]
   public class UserInfo
    {
        private string userNamr;//用户名
        private string userPwd;//密码
        private Image headImg;//头像
        private string slogan;//标语
        private string sex;
        private int age;
        private int userID;//用户编号

        private DateTime regTime;

        public string UserNamr
        {
            get
            {
                return userNamr;
            }

            set
            {
                userNamr = value;
            }
        }

        public string UserPwd
        {
            get
            {
                return userPwd;
            }

            set
            {
                userPwd = value;
            }
        }

        public Image HeadImg
        {
            get
            {
                return headImg;
            }

            set
            {
                headImg = value;
            }
        }

        public string Slogan
        {
            get
            {
                return slogan;
            }

            set
            {
                slogan = value;
            }
        }

        public int UserID
        {
            get
            {
                return userID;
            }

            set
            {
                userID = value;
            }
        }

        public DateTime RegTime
        {
            get
            {
                return regTime;
            }

          
        }

        public string Sex
        {
            get
            {
                return sex;
            }

            set
            {
                sex = value;
            }
        }

        public int Age
        {
            get
            {
                return age;
            }

            set
            {
                age = value;
            }
        }

        public UserInfo(string username,string pwd)
        {
            this.userNamr = username;
            this.userPwd = pwd;
            this.regTime = DateTime.Now;
        }
    }
}
