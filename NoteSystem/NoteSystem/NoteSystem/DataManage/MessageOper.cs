using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.Modles.Node;
using NoteSystem.DataManage;
using NoteSystem.Views.Message;
using NoteSystem.Modles;
using System.Drawing;
namespace NoteSystem.DataManage
{

    /// <summary>
    ///信息操作类
    /// </summary>
     public class MessageOper
    {
        private Message bindMessage;//绑定的Message 

        public MessageOper()
        {

        }

        public Message BindMessage
        {
            get
            {
                return bindMessage;
            }

            set
            {
                bindMessage = value;
            }
        }


        /// <summary>
        /// 创建新的样式
        /// </summary>
        /// <param name="startIndex">样式开始的位置</param>
        /// <param name="font"></param>
        /// <param name="c"></param>
        /// <returns></returns>
        public Message.MessageItem createNowStyle(int startIndex,Font font,Color c)
        {
            Message.MessageItem mi = new Message.MessageItem(startIndex);
            mi.MsgFont = font;
            mi.MsgColor = c;
            //获取当前开始位置是否被其他样式包含
            Message.MessageItem mi1 = getStyle(startIndex);
            if (mi1 != null)
            {
                mi1.EndIndex = startIndex;
            }
            bindMessage.Items.Add(mi);
            return mi;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="point"></param>
        /// <returns></returns>
        public Message.MessageItem getStyle(int point)
        {
            ///获取包含此位置的样式
            for(int i = bindMessage.Items.Count; i >0/* bindMessage.Items.Count; i++*/;i--)
            {
                Message.MessageItem mi = bindMessage.Items[i-1];
                if(mi.StartIndex<=point )
                {
                    return mi;
                }
            }
            return null;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="size"></param>
        public void InsertStyleIength(int size,Message.MessageItem mi)
        {
            if (mi != null)
            {
                int index = bindMessage.Items.IndexOf(mi);//获取样式所在的位置
                if (index != -1)
                {
                    mi = bindMessage.Items[index];
                    mi.Msglength += size;//设置
                    //修改后边样式的起始位置
                    for (index++; index < bindMessage.Items.Count; index++)
                    {
                        mi= bindMessage.Items[index];
                        mi.StartIndex += size;
                    }
                }
            }
        }
        /// <summary>
        /// 获取最后样式
        /// </summary>
        /// <returns></returns>
        public Message.MessageItem getLastStyle()
        {
            if(bindMessage.Items.Count>0)
            return bindMessage.Items[bindMessage.Items.Count-1];
            return null;
        }
        /// <summary>
        /// 获取指定光标后所有的样式
        /// </summary>
        /// <param name="point"></param>
        /// <returns></returns>
        public List<Message.MessageItem> getStyles(int point)
        {
            Message.MessageItem mi = getStyle(point);
            List<Message.MessageItem> mmis = new List<Message.MessageItem>();
            if (mi != null)
            {
                int index = bindMessage.Items.IndexOf(mi);
                for(int i=index;i< bindMessage.Items.Count; i++)
                {
                    mmis.Add(bindMessage.Items[i]);
                }
            }
            return mmis;
        }

        public void DeleteStyle(Message.MessageItem mi)
        {
            bindMessage.Items.Remove(mi);
        }
    }
}
