using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace NoteSystem.Modles.Node
{
    /// <summary>
    /// 便签类
    /// </summary>
    /// 
    [Serializable]
    public  class Note:NoteNode
    {
        /// <summary>
        /// 信息
        /// </summary>
        private Message msg;
     
        public Message Msg
        {
            get
            {
                return msg;
            }

            set
            {
                msg = value;
            }
        }

      

        public Note(NoteType note):base(note)
        {
            msg = new Message();
            this.CreateTime = DateTime.Now;
        }

    }
}
