using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using NoteSystem.Modles.Node;
using NoteSystem.DataManage;
using NoteSystem.Views.Component;
using NoteSystem.Modles;

namespace NoteSystem.DataManage
{
    /// <summary>
    /// 便签操作类
    /// </summary>
    public class NoteOper:NoteBlockOper
    {
        private string userName;
        /// <summary>
        /// 获取当前选择的节点视图
        /// </summary>
        public NoteView NowSelectNoetView
        {
            get
            {
                return nowSelectNoetView;
            }

            set
            {
                //判断是否不是第一次选择
                if (nowSelectNoetView != null)
                {
                    nowSelectNoetView.BackColor = System.Drawing.Color.DodgerBlue;
                }
              
                    nowSelectNoetView = value;
                if (value != null)
                {
                    nowSelectNoetView.BackColor = System.Drawing.Color.DarkSlateBlue;
                }
                }
        }

        /// <summary>
        /// 界面
        /// </summary>
        private NoteViewGroup nvg;     
        private NoteView nowSelectNoetView;
        public NoteOper(string userName,NoteViewGroup nvg):base(userName)
        {
            this.userName = userName;
            this.nvg = nvg;
        }
        /// <summary>
        /// 保存便签
        /// </summary>
        /// <param name="parentType"></param>
        /// <param name="note"></param>
        public Query SaveNewNote(Note note)
        {
            NoteBlock nb = getNoteBlock();//读取便签文件
            //获取对应的父节点
            NoteType nt = getPathNote(getNodeParents(note.ParentNode), nb);
            if (nt != null)
            {
                //判断是否数修改节点
               
                    if (nt.addNode(note))
                {
                    SaveNewBlock(nb);
                    return new Query("", true);

                }
                else
                {
                
                 
                    return new Query("保存失败！名字重复", false);
                }
            }
            return new Query("文件异常", false);

        } 
        /// <summary>
        /// 删除节点
        /// </summary>
        /// <param name="note"></param>
        /// <returns></returns>
        public Query DeleteNote(Note note)
        {
            try { 
            NoteBlock nb = getNoteBlock();
            NoteType nt = getPathNote(getNodeParents(note.ParentNode), nb);
           //     nt.Title = "MMP";
                if (nt.removeNode(note.Title))
                {
                    SaveNewBlock(nb);//保存文件
                    return new Query("删除成功", true);
                }
               
         
            }catch(Exception w)
            {
                return new Query(w.Message, false);
            }
            return new Query("删除失败",false);
        }
        /// <summary>
        /// 更新便签
        /// </summary>
        /// <param name="note"></param>
        /// <returns></returns>
        public Query UpdateNote(Note note)
        {
            try
            {
              //  NoteBlock nb = getNoteBlock();
               // NoteType nt = getPathNote(getNodeParents(note.ParentNode), nb);

                if (DeleteNote(note).Querys) {
                    if (SaveNewNote(note).Querys)
                    {
                        return new Query("修改成功", true);
                    }
                // SaveNewBlock(nb);//保存文件
                }
            }
            catch (Exception w)
            {
                return new Query(w.Message, false);
            }
            return new Query("修改失败", false);
        }
        public void EditNote(NoteView note)
        {
            this.nowSelectNoetView = note;
            nvg.updateNote();
        }
        //  public void 
        public void DeleteNote(NoteView note)
        {
            this.nowSelectNoetView = note;
            nvg.deleteNote();
        }
        /// <summary>
        /// 调用视图中删除的方法
        /// </summary>
        public void ViewDelete()
        {
            nvg.deleteNote();
        }
        /// <summary>
        /// 创建新的节点
        /// </summary>
        public void ViewCreate()
        {
            nvg.CreateNewNote();
        }
        /// <summary>
        /// 创建新的节点
        /// </summary>
        public void ViewCopy()
        {
            nvg.CopyNote();
        }
        /// <summary>
        /// 重命名
        /// </summary>
        /// <param name="title"></param>
        /// <param name="note"></param>
        /// <returns></returns>
        public bool Rename(string title,Note note)
        {
            NoteBlock nb = getNoteBlock();
            NoteType nt = getPathNote(getNodeParents(note.ParentNode), nb);
            NoteNode nn = nt.getNode(note.Title);
            if(!(nn is Note))
            {
                for(int i = 0; i < nt.AllNode.Count; i++)
                {
                    NoteNode n1 = nt.AllNode[i];
                    if(n1 is Note && n1.Title.Equals(note.Title))
                    {
                        nn = n1;
                        break;
                    }
                }
            }
            if (nn == null)
                return false;
           nn .Title = title;
            SaveNewBlock(nb);
            return true;
        }

        public bool Exists(NoteType nt,string title)
        {
            NoteBlock nb = getNoteBlock();
            nt = getPathNote(getNodeParents(nt), nb);
            NoteNode nn = nt.getNode(title);
            if (!(nn is Note))
            {
                for (int i = 0; i < nt.AllNode.Count; i++)
                {
                    NoteNode n1 = nt.AllNode[i];
                    if (n1 is Note && n1.Title.Equals(title))
                    {
                        nn = n1;
                        return true;
                    }
                }
            }
            else
            {
                return true;
            }
            return false;
          
        }

        /// <summary>
        /// 移动节点
        /// </summary>
        public void ViewMove()
        {
            nvg.MoveNote();
        }




    }
}
