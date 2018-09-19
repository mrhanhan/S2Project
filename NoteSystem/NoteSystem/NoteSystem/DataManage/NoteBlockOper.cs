using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.Modles;
using NoteSystem.Modles.Node;

namespace NoteSystem.DataManage
{
    /// <summary>
    /// 便签操作类
    /// </summary>
    public class NoteBlockOper:UserInfoOper
    {
        private string name;
        /// <summary>
        /// 指定便签的用户名
        /// </summary>
        /// <param name="name"></param>
        public NoteBlockOper(string name)
        {
            this.name = name;
        }
        /// <summary>
        /// 添加节点
        /// </summary>
        /// <param name="parentType"></param>
        /// <param name="child"></param>
        /// <returns></returns>
        public Query AddNoteType(NoteType parentType,NoteType child) 
        {
            List<string> path = getNodeParents(parentType);//获取根路径
            NoteBlock bn = getNoteBlock(name);//加载便签
            NoteType nowP = getPathNote(path, bn);
            if (nowP == null)
            {
                return new Query("创建失败！节点错误", false);
            }
            if (nowP.addNode(child)) {
                SaveNewBlock(bn);
            return new Query("创建成功", true);
            }
            else
            {

                return new Query("创建失败，节点存在", false);
            }
        }
        /// <summary>
        /// 添加节点
        /// </summary>
        /// <param name="parentType"></param>
        /// <param name="child"></param>
        /// <returns></returns>
        public Query AddNoteNode(NoteType parentType, NoteNode child)
        {
            List<string> path = getNodeParents(parentType);//获取根路径
            NoteBlock bn = getNoteBlock(name);//加载便签
            NoteType nowP = getPathNote(path, bn);
            if (nowP == null)
            {
                return new Query("创建失败！节点错误", false);
            }
            if (nowP.addNode(child))
            {
                SaveNewBlock(bn);
                return new Query("创建成功", true);
            }
            else
            {

                return new Query("创建失败，节点存在", false);
            }
        }
        /// <summary>
        /// 修改指定名称的节点
        /// </summary>
        /// <param name="pname">要修改节点的名称</param>
        /// <param name="newNt">新的节点</param>
        /// <returns></returns>
        public Query UpdateNoteType(NoteType oldNt, NoteType newNt)
        {
            NoteBlock nb = getNoteBlock();

            if (oldNt == null)
            {
                return new Query("修改失败！节点异常", false);
            }

            NoteType nt = getPathNote(getNodeParents(oldNt), nb);//获取对应文件中的操作节点
            if (nt == null)
            {
                return new Query("修改失败！节点异常", false);
            }
            //判断是不是根节点的子节点
            if (nt.ParentNode == null)
            {//判断名称是否重复
                if (nb.getNode(newNt.Title) != null)
                {
                    (nb.getNode(newNt.Title) as NoteType).Reamark = newNt.Reamark;
                   // return new Query("修改失败！存在此类型的节点["+newNt.Title+"]", false);
                }
              
            }
            else
            {
                //判断名称是否重复
                if (nt.ParentNode.getNode(newNt.Title) != null)
                {
                    (nt.ParentNode.getNode(newNt.Title) as NoteType).Reamark = newNt.Reamark;

                    // return new Query("修改失败！存在此类型的节点[" + newNt.Title + "]", false);
                }
            }

            nt.Title = newNt.Title;
            nt.Reamark = newNt.Reamark;
            try {
                //保存文件
                SaveNewBlock(nb);
                return new Query("修改成功！文件异常",true);
            }
            catch
            {
                return new Query("修改失败！文件异常", false);
            }

        }
        /// <summary>
        /// 删除一个节点
        /// </summary>
        /// <param name="nn"></param>
        /// <returns></returns>
        public Query DeleteNoteNode(NoteNode nn)
        {
            NoteBlock nb = getNoteBlock();
            bool isok = false;
            //判断父节点是不根节点
            if (nn.ParentNode == null)
            {
                isok= nb.removeNode(nn.Title);
            }
            else { 
                //获取NN对应文件中的父节点
              NoteType nt= getPathNote( getNodeParents(nn.ParentNode), nb);
                isok = nt.removeNode(nn.Title);
            }

            if (!isok)
            {
                return new Query("删除失败！节点异常", false);
            }
            try { 
            SaveNewBlock(nb);
                return new Query("删除成功", true);
            }
            catch
            {
                return new Query("删除失败！文件异常", false);
            }

        }
        /// <summary>
        /// 移动节点
        /// </summary>
        /// <param name="child"></param>
        /// <param name="newParent"></param>
        /// <returns></returns>
        public Query MoveNoteNode(NoteNode child,NoteType newParent)
        {
            if (newParent == null)
            {
                return  new Query("移动失败！无法移动到根节点", false);
            }
            NoteBlock nb = getNoteBlock();
            NoteType ntP = getPathNote(getNodeParents(newParent), nb);//获取文件中对应的新的节点
            NoteNode ch = null;//文件中对应的子节点
            bool a = false;
            if (child.ParentNode == null)
            {
                return new Query("移动失败！无法移动根节点", false);
            }
            else
            {
                NoteType chP= getPathNote(getNodeParents(child.ParentNode), nb);
                ch = chP.getNode(child.Title);
               a= chP.removeNode(child.Title);
            }
          

            if(!a || ch == null)
            {
                return new Query("移动失败！",false);
            }
            if (!ntP.addNode(ch))
            {
                return new Query("移动失败！目标类型中出现重名", false);
            }

            try
            {
                SaveNewBlock(nb);
                return new Query("移动成功！", true);
            }
            catch
            {
                return new Query("移动失败！文件异常", false);
            }



        }
        public Query CopyNoteNode(NoteNode child, NoteType newParent)
        {
            if (newParent == null)
            {
                return new Query("移动失败！无法移动到根节点", false);
            }
            NoteBlock nb = getNoteBlock();
            NoteType ntP = getPathNote(getNodeParents(newParent), nb);//获取文件中对应的新的节点
            NoteNode ch = null;//文件中对应的子节点
            NoteNode ch1 = null;//文件中对应的子节点
            bool a = false;
            if (child.ParentNode == null)
            {
                ch = nb.getNode(child.Title);
            }
            else
            {
                NoteType chP = getPathNote(getNodeParents(child.ParentNode), nb);
                ch = chP.getNode(child.Title);
               
              //  a = chP.removeNode(child.Title);
            }
            ///克隆对象
            ch1 = ch.Clone() as NoteNode;
            



            if ( ch == null )
            {
                return new Query("复制失败！", false);
            }

            if (ch.Equals(ch1))
            {
                return new Query("复制失败！对象克隆失败", false);
            }


            if (!ntP.addNode(ch1))
            {
                return new Query("复制失败！目标类型中出现重名", false);
            }

            try
            {
                SaveNewBlock(nb);
                return new Query("复制成功！", true);
            }
            catch
            {
                return new Query("复制失败！文件异常", false);
            }

        }
        protected NoteType getPathNote(List<string> path, NoteBlock bn)
        {
            NoteType nowP = null;//当前节点
            NoteNode nn = null;
            foreach (string p in path)
            {
                if (nowP == null)
                {
                    if (p != "回收站")
                        nn = bn.getNode(p);
                    else
                        nn = bn.Recycle;
                }
                else
                    nn = nowP.getNode(p);

                if (nn is NoteType)
                {
                    nowP = nn as NoteType;
                }
                else
                {
                    return null;
                }
            }
            return nowP;
        }
        /// <summary>
        /// 导出节点
        /// </summary>
        /// <param name="exp"></param>
        /// <returns></returns>
        public Query ExpNoteType(NoteNode exp,string path)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            NoteBlock nb = getNoteBlock();
            exp = getPathNote(getNodeParents(exp.ParentNode), nb).getNode(exp.Title);
            if (ndfo.SaveNoteNodeFile(path, exp))
            {
                return new Query("导出成功", true);
            }
            else
            {

                return new Query("导出失败！文件异常", false);
            }

        }
       /// <summary>
       /// 导入节点
       /// </summary>
       /// <param name="path"></param>
       /// <returns></returns>
        public Query ImpNoteNode(string path,NoteType ntp)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();

            NoteBlock nb = getNoteBlock();
            if(ntp.Title!="回收站")
            ntp = getPathNote(getNodeParents(ntp), nb);
            else{
                ntp = nb.Recycle;
            }

           NoteNode nn= ndfo.ReadNoteNodeFile(path);
            if (nn == null)
            {
                return new Query("导入失败!文件异常", false);
            }
           if(ntp.addNode(nn))
            {
                try {
                    SaveNewBlock(nb);
                    nb = getNoteBlock();
                    return new Query("导入成功!", true);
                }
                catch
                {
                    return new Query("导入失败!文件错误", false);
                }
              
              
            }
            else
            {
                return new Query("倒入失败!重复名称", false);
            }
        }
        /// <summary>
        /// 倒入文件
        /// </summary>
        /// <param name="path"></param>
        /// <returns></returns>
        public NoteNode ImpNoteNode(string path)
        {
            NoteDateFileOper ndfo = new NoteDateFileOper();
            NoteNode nn = ndfo.ReadNoteNodeFile(path);
            return nn;
           
        }
        /// <summary>
        /// 获取当前便签
        /// </summary>
        /// <returns></returns>
        public  NoteBlock getNoteBlock()
        {
            return base.getNoteBlock(name);
        }
        /// <summary>
        /// 获取指定节点到根路径的位置
        /// </summary>
        /// <param name="child"></param>
        /// <returns></returns>
        protected List<string> getNodeParents(NoteNode child)
        {
            List<string> paths = new List<string>();
            if (child != null)
            {
                paths.Insert(0, child.Title);
                parents(paths, child.ParentNode);
            }
            return paths;
             
        }
        /// <summary>
        /// 递归函数，辅助getNodeParents
        /// </summary>
        /// <param name="lst"></param>
        /// <param name="no"></param>
        protected void parents(List<string> lst,NoteType no)
        {
            if (no != null) {
                lst.Insert(0, no.Title);
                parents(lst,no.ParentNode);
            }
        }
        /// <summary>
        /// 保存新的文件
        /// </summary>
        /// <param name="bn"></param>
        public void SaveNewBlock(NoteBlock bn)
        {
            UserInfo user = getUserInfo(name);
            new NoteDateFileOper().SaveNoteFile(user.UserID + "", bn);

        }
        /// <summary>
        /// 获取指定对象所隐射的文件中对象
        /// </summary>
        /// <param name="nt"></param>
        /// <returns></returns>
        public NoteType getType(NoteNode nt)
        {
           NoteBlock nb= getNoteBlock();
            if (nt.Title == "回收站")
                return nb.Recycle;
            if (nt.ParentNode == null)
            {
                return nb.getNode(nt.Title) as NoteType;
            }
            else
            {
                return  (getPathNote(getNodeParents(nt), nb) as NoteType);
            }
        }

        /// <summary>
        /// 格式化
        /// </summary>
        public void ClearAll()
        {
            this.SaveNewBlock(new NoteBlock(name));
        }

        /// <summary>
        /// 格式化
        /// </summary>
        public void ClearAll(NoteType nt)
        {
            NoteBlock nb = getNoteBlock();
            NoteType n = getPathNote(getNodeParents(nt), nb);
            for(int i=0;i<n.AllNode.Count;)
            {
                n.removeNode(n.AllNode[i].Title);
            }
            SaveNewBlock(nb);

        }
    }
    /// <summary>
    /// 结果
    /// </summary>
    public class Query
    {
        private bool querys;
        private string msg;

        public bool Querys
        {
            get
            {
                return querys;
            }

            set
            {
                querys = value;
            }
        }

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
        public Query(string msg,bool ok)
        {
            this.querys = ok;
            this.msg = msg;
        }
    }
}
