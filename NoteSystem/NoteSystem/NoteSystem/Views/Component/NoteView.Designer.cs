namespace NoteSystem.Views.Component
{
    partial class NoteView
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
            this.noteName = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.labTypeName = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.noteUser = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.time = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.txtRMK = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.itemsMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.编辑ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.创建新的ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator3 = new System.Windows.Forms.ToolStripSeparator();
            this.复制ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.移动ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.重命名ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.itemsMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // noteName
            // 
            this.noteName.AutoSize = true;
            this.noteName.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.noteName.ForeColor = System.Drawing.Color.White;
            this.noteName.Location = new System.Drawing.Point(114, 19);
            this.noteName.Name = "noteName";
            this.noteName.Size = new System.Drawing.Size(39, 15);
            this.noteName.TabIndex = 0;
            this.noteName.Text = "老王";
            this.noteName.Click += new System.EventHandler(this.noteName_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(26, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 15);
            this.label1.TabIndex = 1;
            this.label1.Text = "便签名称：";
            this.label1.Click += new System.EventHandler(this.noteName_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(26, 55);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(87, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "类型名称：";
            this.label2.Click += new System.EventHandler(this.noteName_Click);
            // 
            // labTypeName
            // 
            this.labTypeName.AutoSize = true;
            this.labTypeName.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.labTypeName.ForeColor = System.Drawing.Color.White;
            this.labTypeName.Location = new System.Drawing.Point(114, 55);
            this.labTypeName.Name = "labTypeName";
            this.labTypeName.Size = new System.Drawing.Size(71, 15);
            this.labTypeName.TabIndex = 1;
            this.labTypeName.Text = "我得笔记";
            this.labTypeName.Click += new System.EventHandler(this.noteName_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(219, 19);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(87, 15);
            this.label4.TabIndex = 1;
            this.label4.Text = "所属用户：";
            this.label4.Click += new System.EventHandler(this.noteName_Click);
            // 
            // noteUser
            // 
            this.noteUser.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.noteUser.ForeColor = System.Drawing.Color.White;
            this.noteUser.Location = new System.Drawing.Point(307, 19);
            this.noteUser.Name = "noteUser";
            this.noteUser.Size = new System.Drawing.Size(126, 51);
            this.noteUser.TabIndex = 1;
            this.noteUser.Text = "我得笔记";
            this.noteUser.Click += new System.EventHandler(this.noteName_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label6.ForeColor = System.Drawing.Color.White;
            this.label6.Location = new System.Drawing.Point(219, 90);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(87, 15);
            this.label6.TabIndex = 1;
            this.label6.Text = "创建时间：";
            this.label6.Click += new System.EventHandler(this.noteName_Click);
            // 
            // time
            // 
            this.time.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.time.ForeColor = System.Drawing.Color.White;
            this.time.Location = new System.Drawing.Point(307, 90);
            this.time.Name = "time";
            this.time.Size = new System.Drawing.Size(126, 73);
            this.time.TabIndex = 1;
            this.time.Text = "我得笔记";
            this.time.Click += new System.EventHandler(this.noteName_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label8.ForeColor = System.Drawing.Color.White;
            this.label8.Location = new System.Drawing.Point(26, 90);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(87, 15);
            this.label8.TabIndex = 1;
            this.label8.Text = "类型简介：";
            this.label8.Click += new System.EventHandler(this.noteName_Click);
            // 
            // txtRMK
            // 
            this.txtRMK.Location = new System.Drawing.Point(29, 121);
            this.txtRMK.Multiline = true;
            this.txtRMK.Name = "txtRMK";
            this.txtRMK.ReadOnly = true;
            this.txtRMK.Size = new System.Drawing.Size(206, 69);
            this.txtRMK.TabIndex = 2;
            this.txtRMK.Click += new System.EventHandler(this.noteName_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(382, 166);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(64, 24);
            this.button1.TabIndex = 3;
            this.button1.Text = "编辑";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(312, 166);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(64, 24);
            this.button2.TabIndex = 3;
            this.button2.Text = "导出";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(242, 166);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(64, 24);
            this.button3.TabIndex = 3;
            this.button3.Text = "删除";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // itemsMenu
            // 
            this.itemsMenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.itemsMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.删除ToolStripMenuItem,
            this.编辑ToolStripMenuItem,
            this.创建新的ToolStripMenuItem,
            this.toolStripSeparator3,
            this.复制ToolStripMenuItem,
            this.移动ToolStripMenuItem,
            this.重命名ToolStripMenuItem});
            this.itemsMenu.Name = "contextMenuStrip1";
            this.itemsMenu.Size = new System.Drawing.Size(176, 182);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.删除ToolStripMenuItem.Text = "删除";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // 编辑ToolStripMenuItem
            // 
            this.编辑ToolStripMenuItem.Name = "编辑ToolStripMenuItem";
            this.编辑ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.编辑ToolStripMenuItem.Text = "编辑";
            this.编辑ToolStripMenuItem.Click += new System.EventHandler(this.编辑ToolStripMenuItem_Click);
            // 
            // 创建新的ToolStripMenuItem
            // 
            this.创建新的ToolStripMenuItem.Name = "创建新的ToolStripMenuItem";
            this.创建新的ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.创建新的ToolStripMenuItem.Text = "创建新的";
            this.创建新的ToolStripMenuItem.Click += new System.EventHandler(this.创建新的ToolStripMenuItem_Click);
            // 
            // toolStripSeparator3
            // 
            this.toolStripSeparator3.Name = "toolStripSeparator3";
            this.toolStripSeparator3.Size = new System.Drawing.Size(172, 6);
            // 
            // 复制ToolStripMenuItem
            // 
            this.复制ToolStripMenuItem.Name = "复制ToolStripMenuItem";
            this.复制ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.复制ToolStripMenuItem.Text = "复制到";
            this.复制ToolStripMenuItem.Click += new System.EventHandler(this.复制ToolStripMenuItem_Click);
            // 
            // 移动ToolStripMenuItem
            // 
            this.移动ToolStripMenuItem.Name = "移动ToolStripMenuItem";
            this.移动ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.移动ToolStripMenuItem.Text = "移动到";
            this.移动ToolStripMenuItem.Click += new System.EventHandler(this.移动ToolStripMenuItem_Click);
            // 
            // 重命名ToolStripMenuItem
            // 
            this.重命名ToolStripMenuItem.Name = "重命名ToolStripMenuItem";
            this.重命名ToolStripMenuItem.Size = new System.Drawing.Size(175, 24);
            this.重命名ToolStripMenuItem.Text = "重命名";
            this.重命名ToolStripMenuItem.Click += new System.EventHandler(this.重命名ToolStripMenuItem_Click);
            // 
            // NoteView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DodgerBlue;
            this.ContextMenuStrip = this.itemsMenu;
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.txtRMK);
            this.Controls.Add(this.noteUser);
            this.Controls.Add(this.time);
            this.Controls.Add(this.labTypeName);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.noteName);
            this.Name = "NoteView";
            this.Size = new System.Drawing.Size(450, 206);
            this.Click += new System.EventHandler(this.noteName_Click);
            this.itemsMenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label noteName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label labTypeName;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label noteUser;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label time;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox txtRMK;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.ContextMenuStrip itemsMenu;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 编辑ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 创建新的ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator3;
        private System.Windows.Forms.ToolStripMenuItem 复制ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 移动ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 重命名ToolStripMenuItem;
    }
}
