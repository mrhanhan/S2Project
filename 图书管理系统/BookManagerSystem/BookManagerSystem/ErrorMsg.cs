using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagerSystem
{
    
    public struct ErrorMsg
    {
        /// <summary>
        /// 错误时间
        /// </summary>
        private string date;
        /// <summary>
        /// 设置获取错误时间
        /// </summary>
        public string Date
        {
            get { return date; }
            set { date = value; }
        }
        /// <summary>
        /// 错误信息
        /// </summary>
        private string errorMsg;
        /// <summary>
        /// 设置获取错误信息
        /// </summary>
        public string ErrorMessage
        {
            get { return errorMsg; }
            set { errorMsg = value; }
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public ErrorMsg(string date,string msg)
        {
            this.date = date;
            this.errorMsg = msg;
        }
        /// <summary>
        /// 重写
        /// </summary>
        /// <param name="obj"></param>
        /// <returns></returns>
        public override bool Equals(object obj)
        {
            if (obj is ErrorMsg)
            {
                ErrorMsg em = (ErrorMsg)obj;
                return date.Equals(em.date) && errorMsg.Equals(em.errorMsg);

            }
            return false;
        }
    }
}
