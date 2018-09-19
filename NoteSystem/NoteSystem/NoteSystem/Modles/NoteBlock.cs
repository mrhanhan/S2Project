using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.DataManage;
using NoteSystem.Modles.Node;
namespace NoteSystem.Modles
{
    /// <summary>
    /// 便签集,包含用户信息，便签类型信息
    /// </summary>
    /// 
    [Serializable]
   public  class NoteBlock :BaseNote
    {
        /// <summary>
        /// 此便签用户
        /// </summary>
        private string username;
        /// <summary>
        /// 当前块下的所有节点，和节点文件
        /// </summary>
        private List<NoteNode> allNode;

        private NoteType recycle;//回收站

        public string Username
        {
            get
            {
                return username;
            }

            set
            {
                username = value;
            }
        }

        public NoteType Recycle
        {
            get
            {
                return recycle;
            }

            set
            {
                recycle = value;
            }
        }

        public List<NoteNode> AllNode
        {
            get
            {
                return allNode;
            }

            set
            {
                allNode = value;
            }
        }

        public NoteBlock(string username)
        {
            this.Username = username;
            this.Title = username + "的便签";
            AllNode = new List<NoteNode>();
            recycle = new NoteType("回收站");
            recycle.NoteBlock = this;
            NoteType nt = new NoteType("我的笔记");
            nt.NoteBlock = this;
            nt.Reamark = "记录您生活中的点点滴滴";


       

            AllNode.Add(nt);
             nt = new NoteType("我的分享");
            nt.Reamark = "分享您生活中的点点滴滴";
            nt.NoteBlock = this;
            AllNode.Add(nt);
            this.CreateTime = DateTime.Now;
           






        }
        /// <summary>
        /// 获取指定title的节点
        /// </summary>
        /// <param name="node"></param>
        /// <returns></returns>
        public NoteNode getNode(string title)
        {
            try
            {
                foreach(NoteNode nn in AllNode)
                {
                    if (title.Equals(nn.Title)) 
                    return nn;
                }
            }
            catch
            {
               
            }
            return null;

        }
        /// <summary>
        /// 添加节点
        /// </summary>
        /// <param name="nn"></param>
        /// <returns></returns>
        public bool addNode(NoteNode nn)
        {
            if (getNode(nn.Title) == null)
                return false;

            AllNode.Add(nn);
            nn.NoteBlock = this;
            nn.ParentNode = null;
            return true;
        }
        /// <summary>
        /// 移除指定Title的节点
        /// </summary>
        /// <param name="title"></param>
        /// <returns></returns>
        public bool removeNode(string title)
        {
            return AllNode.Remove(getNode(title));
        }
    }
}
