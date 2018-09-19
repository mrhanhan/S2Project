using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoteSystem.Modles
{
    [Serializable]
    public  class NoteNode:BaseNote
    {
        private NoteType parentNode;//父节点

        internal NoteType ParentNode
        {
            get
            {
                return parentNode;
            }

            set
            {
                parentNode = value;
            }
        }

        internal NoteBlock NoteBlock
        {
            get
            {
                return noteBlock;
            }

            set
            {
                noteBlock = value;
            }
        }

        /// <summary>
        /// 便签节点
        /// </summary>
        private NoteBlock noteBlock;

        public NoteNode()
        {

        }

        public NoteNode(NoteType parent)
        {
            parentNode = parent;
        }
    }
}
