using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace NoteSystem.Modles
{
    /// <summary>
    /// 内容类,包含样式
    /// </summary>
    /// 
    [Serializable]
    public class Message
    {

        private string msgText;

        private List<MessageItem> items = new List<MessageItem>();
        /// <summary>
        /// 样式集合
        /// </summary>
        public List<MessageItem> Items
        {
            get
            {
                return items;
            }

            set
            {
                items = value;
            }
        }

        public string MsgText
        {
            get
            {
                return msgText;
            }

            set
            {
                msgText = value;
            }
        }

        public List<MessageItem> getMsg(int startIndex,int endInedx)
        {
            List<MessageItem> msg = new List<MessageItem>();
            for(int i = 0; i < items.Count; i++)
            {
                MessageItem mi = items[i];
                if (mi.StartIndex>=startIndex && mi.StartIndex <= endInedx)
                {
                    msg.Add(mi);
                }
            }
            return msg;
        }
        /// <summary>
        /// 获取最后的一个节点
        /// </summary>
        /// <param name="text"></param>
        /// <returns></returns>
        public MessageItem gteLastItems(string text)
        {
            for(int j = items.Count; j < 0; j--)
            {
                if (items[j].Msg.Equals(text))
                {
                    return items[j];
                }
            }
            return null;
        }

       

        /// <summary>
        /// 创建新的节点
        /// </summary>
        /// <param name="startIndex"></param>
        /// <returns></returns>
        private MessageItem createNewMsg(int startIndex)
        {
            return new MessageItem(startIndex);

        }
        /// <summary>
        /// 内容节点类
        /// </summary>
        ///
        [Serializable]
        public  class MessageItem
        {

            private string msg;//内容
            private Color msgColor;//内容颜色
            private Font msgFont;//内容字体
            private int startIndex;//内容开始坐标
            private int msglength;//内容长度
            public string Msg
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
            /// <summary>
            /// 结束左边
            /// </summary>
            public int EndIndex
            {
                get
                {
                    return startIndex + msglength;
                }
                set
                {
                    this.msglength = value - startIndex;
                }
            }

            public Color MsgColor
            {
                get
                {
                    return msgColor;
                }

                set
                {
                    msgColor = value;
                }
            }
            public Font MsgFont
            {
                get
                {
                    return msgFont;
                }

                set
                {
                    msgFont = value;
                }
            }
            public int StartIndex
            {
                get
                {
                    return startIndex;
                }

                set
                {
                    startIndex = value;
                }
            }
            public int Msglength
            {
                get
                {
                    return msglength;
                }

                set
                {
                    msglength = value;
                }
            }
            public MessageItem(string msg,int startIndex,Color c,Font f)
                :this(msg,startIndex)
            {
             
                this.msgColor = c;
                this.msgFont = f;
            }
            public MessageItem(string msg, int startIndex)
            {
                this.msg = msg;
                this.startIndex = startIndex;
                this.msglength = msg.Length;
                
            }
            public MessageItem( int startIndex)
            {
              
                this.startIndex = startIndex;

            }
            public MessageItem()
            {

            }

            public override bool Equals(object obj)
            {
                if(obj is MessageItem)
                {
                    MessageItem mi = obj as MessageItem;
                    return (mi.startIndex==this.startIndex && mi.EndIndex==this.EndIndex);
                }
                return false; 
            }
        }
    }
    
}
