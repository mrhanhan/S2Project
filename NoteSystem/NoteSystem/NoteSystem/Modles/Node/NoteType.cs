using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace NoteSystem.Modles
{
    /// <summary>
    ///便签类型,类
    /// </summary>
    /// 
    [Serializable]
    public class NoteType : NoteNode
    {

        private string reamark;

        public string Reamark
        {
            get
            {
                return reamark;
            }

            set
            {
                reamark = value;
            }
        }

        /// <summary>
        /// 当前块下的所有节点，和节点文件
        /// </summary>
        private List<NoteNode> allNode;

        internal List<NoteNode> AllNode
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

        public NoteType(string title, string remk)
        {
            this.Reamark = remk;
            this.CreateTime = DateTime.Now;
            this.Title = title;
            allNode = new List<NoteNode>();
        }
        public NoteType(string title)
        {
            this.Title = title;
            this.CreateTime = DateTime.Now;
            allNode = new List<NoteNode>();
        }
        /// <summary>
        /// 添加节点
        /// </summary>
        /// <param name="nt"></param>
        public void addNodes(NoteNode nt)
        {
            nt.NoteBlock = this.NoteBlock;
            nt.ParentNode = this;
            this.allNode.Add(nt);
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
                foreach (NoteNode nn in allNode)
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
            NoteNode n = getNode(nn.Title);
            if (n != null)
            {
                //if (n.GetType().ToString().Equals( nn.GetType().ToString()))
                    return false;
            }

            allNode.Add(nn);
            nn.NoteBlock = this.NoteBlock;
            nn.ParentNode = this;
            if(nn is NoteType)
            {
                (nn as NoteType).setAllNoteBlock(this.NoteBlock);
            }
            return true;
        }
        /// <summary>
        /// 移除指定Title的节点
        /// </summary>
        /// <param name="title"></param>
        /// <returns></returns>
        public bool removeNode(string title)
        {
            NoteNode nn = getNode(title);
            nn.ParentNode = null;
            nn.NoteBlock = null;
            return allNode.Remove(nn);
        }


        public void setAllNoteBlock(NoteBlock nb)
        {
            this.NoteBlock = nb;
            foreach(NoteNode nn in allNode)
            {
                if(nn is NoteType)
                {
                    (nn as NoteType).setAllNoteBlock(nb);
                }
                else
                {
                    nn.NoteBlock = nb;
                }
            }
        }
    }
}
