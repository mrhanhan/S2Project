namespace NoteSystem.Views.Component
{
    partial class NoteViewGroup
    {
        /// <summary> 
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary> 
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(NoteViewGroup));
            this.panel1 = new System.Windows.Forms.Panel();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.tslabNoteType = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.BtnCreateNote = new System.Windows.Forms.ToolStripButton();
            this.BtnUpdateNote = new System.Windows.Forms.ToolStripButton();
            this.DeleteNote = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.BtnImpTxt = new System.Windows.Forms.ToolStripButton();
            this.BtnExpTxt = new System.Windows.Forms.ToolStripButton();
            this.BtnImpNote = new System.Windows.Forms.ToolStripButton();
            this.BtnExpNote = new System.Windows.Forms.ToolStripButton();
            this.PanelBoxy = new System.Windows.Forms.Panel();
            this.vScrollBar1 = new System.Windows.Forms.VScrollBar();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.panel1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.toolStrip1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(910, 60);
            this.panel1.TabIndex = 0;
            // 
            // toolStrip1
            // 
            this.toolStrip1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.toolStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton1,
            this.tslabNoteType,
            this.toolStripSeparator1,
            this.BtnCreateNote,
            this.BtnUpdateNote,
            this.DeleteNote,
            this.toolStripSeparator2,
            this.BtnImpTxt,
            this.BtnExpTxt,
            this.BtnImpNote,
            this.BtnExpNote});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(910, 60);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolStripButton1.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton1.Image")));
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(103, 57);
            this.toolStripButton1.Text = "当前文件夹：";
            this.toolStripButton1.Click += new System.EventHandler(this.toolStripButton1_Click);
            // 
            // tslabNoteType
            // 
            this.tslabNoteType.Name = "tslabNoteType";
            this.tslabNoteType.Size = new System.Drawing.Size(35, 57);
            this.tslabNoteType.Text = "null";
            this.tslabNoteType.Click += new System.EventHandler(this.tslabNoteType_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 60);
            // 
            // BtnCreateNote
            // 
            this.BtnCreateNote.Image = global::NoteSystem.Properties.Resources.Create;
            this.BtnCreateNote.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnCreateNote.Name = "BtnCreateNote";
            this.BtnCreateNote.Size = new System.Drawing.Size(93, 57);
            this.BtnCreateNote.Text = "创建便签";
            this.BtnCreateNote.Click += new System.EventHandler(this.BtnCreateNote_Click);
            // 
            // BtnUpdateNote
            // 
            this.BtnUpdateNote.Image = global::NoteSystem.Properties.Resources.update;
            this.BtnUpdateNote.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnUpdateNote.Name = "BtnUpdateNote";
            this.BtnUpdateNote.Size = new System.Drawing.Size(93, 57);
            this.BtnUpdateNote.Text = "修改便签";
            this.BtnUpdateNote.Click += new System.EventHandler(this.BtnUpdateNote_Click);
            // 
            // DeleteNote
            // 
            this.DeleteNote.Image = global::NoteSystem.Properties.Resources.dle;
            this.DeleteNote.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.DeleteNote.Name = "DeleteNote";
            this.DeleteNote.Size = new System.Drawing.Size(93, 57);
            this.DeleteNote.Text = "删除便签";
            this.DeleteNote.Click += new System.EventHandler(this.DeleteNote_Click);
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(6, 60);
            // 
            // BtnImpTxt
            // 
            this.BtnImpTxt.Image = global::NoteSystem.Properties.Resources.imp;
            this.BtnImpTxt.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnImpTxt.Name = "BtnImpTxt";
            this.BtnImpTxt.Size = new System.Drawing.Size(93, 57);
            this.BtnImpTxt.Text = "导入文件";
            this.BtnImpTxt.Click += new System.EventHandler(this.BtnImpTxt_Click);
            // 
            // BtnExpTxt
            // 
            this.BtnExpTxt.Image = global::NoteSystem.Properties.Resources.exp;
            this.BtnExpTxt.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnExpTxt.Name = "BtnExpTxt";
            this.BtnExpTxt.Size = new System.Drawing.Size(93, 57);
            this.BtnExpTxt.Text = "导出文件";
            this.BtnExpTxt.Click += new System.EventHandler(this.BtnExpTxt_Click);
            // 
            // BtnImpNote
            // 
            this.BtnImpNote.Image = global::NoteSystem.Properties.Resources.imp;
            this.BtnImpNote.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnImpNote.Name = "BtnImpNote";
            this.BtnImpNote.Size = new System.Drawing.Size(93, 57);
            this.BtnImpNote.Text = "导入便签";
            this.BtnImpNote.Click += new System.EventHandler(this.BtnImpNote_Click);
            // 
            // BtnExpNote
            // 
            this.BtnExpNote.Image = global::NoteSystem.Properties.Resources.exp;
            this.BtnExpNote.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.BtnExpNote.Name = "BtnExpNote";
            this.BtnExpNote.Size = new System.Drawing.Size(108, 57);
            this.BtnExpNote.Text = "导出此便签";
            this.BtnExpNote.Click += new System.EventHandler(this.BtnExpNote_Click);
            // 
            // PanelBoxy
            // 
            this.PanelBoxy.Dock = System.Windows.Forms.DockStyle.Fill;
            this.PanelBoxy.Location = new System.Drawing.Point(0, 60);
            this.PanelBoxy.Name = "PanelBoxy";
            this.PanelBoxy.Size = new System.Drawing.Size(910, 287);
            this.PanelBoxy.TabIndex = 1;
            this.PanelBoxy.Scroll += new System.Windows.Forms.ScrollEventHandler(this.PanelBoxy_Scroll);
            this.PanelBoxy.Layout += new System.Windows.Forms.LayoutEventHandler(this.PanelBoxy_Layout);
            this.PanelBoxy.MouseWheel += new System.Windows.Forms.MouseEventHandler(this.Panel_MouseWheel);
            // 
            // vScrollBar1
            // 
            this.vScrollBar1.Dock = System.Windows.Forms.DockStyle.Right;
            this.vScrollBar1.Location = new System.Drawing.Point(889, 60);
            this.vScrollBar1.Name = "vScrollBar1";
            this.vScrollBar1.Size = new System.Drawing.Size(21, 287);
            this.vScrollBar1.TabIndex = 2;
            this.vScrollBar1.Scroll += new System.Windows.Forms.ScrollEventHandler(this.vScrollBar1_Scroll);
            // 
            // toolTip1
            // 
            this.toolTip1.AutomaticDelay = 300;
            this.toolTip1.AutoPopDelay = 3000;
            this.toolTip1.InitialDelay = 200;
            this.toolTip1.IsBalloon = true;
            this.toolTip1.ReshowDelay = 60;
            // 
            // NoteViewGroup
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.vScrollBar1);
            this.Controls.Add(this.PanelBoxy);
            this.Controls.Add(this.panel1);
            this.Name = "NoteViewGroup";
            this.Size = new System.Drawing.Size(910, 347);
            this.Load += new System.EventHandler(this.NoteViewGroup_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ToolStripLabel tslabNoteType;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripButton BtnCreateNote;
        private System.Windows.Forms.ToolStripButton BtnUpdateNote;
        private System.Windows.Forms.ToolStripButton DeleteNote;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripButton BtnImpTxt;
        private System.Windows.Forms.ToolStripButton BtnImpNote;
        private System.Windows.Forms.ToolStripButton BtnExpNote;
        private System.Windows.Forms.ToolStripButton BtnExpTxt;
        private System.Windows.Forms.Panel PanelBoxy;
        private System.Windows.Forms.VScrollBar vScrollBar1;
        private System.Windows.Forms.ToolTip toolTip1;
    }
}
