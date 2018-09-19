namespace NoteSystem.Views.Component
{
    partial class BaseNoteControl
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
            this.ToolsLayou = new System.Windows.Forms.Panel();
            this.ContentLayout = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // ToolsLayou
            // 
            this.ToolsLayou.Dock = System.Windows.Forms.DockStyle.Top;
            this.ToolsLayou.Location = new System.Drawing.Point(0, 0);
            this.ToolsLayou.Name = "ToolsLayou";
            this.ToolsLayou.Size = new System.Drawing.Size(661, 66);
            this.ToolsLayou.TabIndex = 0;
            // 
            // ContentLayout
            // 
            this.ContentLayout.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ContentLayout.Location = new System.Drawing.Point(0, 66);
            this.ContentLayout.Name = "ContentLayout";
            this.ContentLayout.Size = new System.Drawing.Size(661, 410);
            this.ContentLayout.TabIndex = 1;
            // 
            // BaseNoteControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.ContentLayout);
            this.Controls.Add(this.ToolsLayou);
            this.Name = "BaseNoteControl";
            this.Size = new System.Drawing.Size(661, 476);
            this.ResumeLayout(false);

        }

        #endregion

        protected System.Windows.Forms.Panel ToolsLayou;
        protected System.Windows.Forms.Panel ContentLayout;
    }
}
