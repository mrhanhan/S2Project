namespace NoteSystem.Views
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.TreeNode treeNode1 = new System.Windows.Forms.TreeNode("节点0");
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            this.labUserName = new System.Windows.Forms.Label();
            this.labSelect = new System.Windows.Forms.Label();
            this.selectMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.用户信息ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.退出ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.注销ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.注销并最小化ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.Task_JC = new System.Windows.Forms.Timer(this.components);
            this.btnSeting = new System.Windows.Forms.Button();
            this.noteSettingSelect = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.格式化所有ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.退出APPToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator4 = new System.Windows.Forms.ToolStripSeparator();
            this.退出程序ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.SpBody = new System.Windows.Forms.SplitContainer();
            this.blocks = new System.Windows.Forms.TreeView();
            this.contextBlockMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.创建类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.修改类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator6 = new System.Windows.Forms.ToolStripSeparator();
            this.导出类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.倒入类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator7 = new System.Windows.Forms.ToolStripSeparator();
            this.移动类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.复制类型ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator8 = new System.Windows.Forms.ToolStripSeparator();
            this.格式化所有ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.刷新ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.现实便签ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.iconList = new System.Windows.Forms.ImageList(this.components);
            this.panel1 = new System.Windows.Forms.Panel();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tsBtnCreateType = new System.Windows.Forms.ToolStripButton();
            this.tsBtnDelType = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.tsBtnExpType = new System.Windows.Forms.ToolStripButton();
            this.tsBtnImpType = new System.Windows.Forms.ToolStripButton();
            this.BottomToolStripPanel = new System.Windows.Forms.ToolStripPanel();
            this.TopToolStripPanel = new System.Windows.Forms.ToolStripPanel();
            this.RightToolStripPanel = new System.Windows.Forms.ToolStripPanel();
            this.LeftToolStripPanel = new System.Windows.Forms.ToolStripPanel();
            this.ContentPanel = new System.Windows.Forms.ToolStripContentPanel();
            this.notifyIcon1 = new System.Windows.Forms.NotifyIcon(this.components);
            this.cmNotifyMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.打开ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.注销ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator5 = new System.Windows.Forms.ToolStripSeparator();
            this.退出ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.picUserHeadImg = new System.Windows.Forms.PictureBox();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.MenuLayout.SuspendLayout();
            this.BodyLayou.SuspendLayout();
            this.selectMenu.SuspendLayout();
            this.noteSettingSelect.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.SpBody)).BeginInit();
            this.SpBody.Panel1.SuspendLayout();
            this.SpBody.SuspendLayout();
            this.contextBlockMenu.SuspendLayout();
            this.panel1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            this.cmNotifyMenu.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picUserHeadImg)).BeginInit();
            this.SuspendLayout();
            // 
            // closebtn
            // 
            this.closebtn.FlatAppearance.BorderSize = 0;
            this.closebtn.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.closebtn.Location = new System.Drawing.Point(1068, 3);
            this.closebtn.Size = new System.Drawing.Size(54, 48);
            this.closebtn.Text = "X";
            this.closebtn.Click += new System.EventHandler(this.closebtn_Click_1);
            // 
            // MenuLayout
            // 
            this.MenuLayout.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)));
            this.MenuLayout.Controls.Add(this.btnSeting);
            this.MenuLayout.Controls.Add(this.labSelect);
            this.MenuLayout.Controls.Add(this.labUserName);
            this.MenuLayout.Controls.Add(this.picUserHeadImg);
            this.MenuLayout.Dock = System.Windows.Forms.DockStyle.Top;
            this.MenuLayout.Location = new System.Drawing.Point(0, 0);
            this.MenuLayout.MinimumSize = new System.Drawing.Size(1125, 60);
            this.MenuLayout.Size = new System.Drawing.Size(1125, 60);
            this.MenuLayout.Controls.SetChildIndex(this.picUserHeadImg, 0);
            this.MenuLayout.Controls.SetChildIndex(this.labUserName, 0);
            this.MenuLayout.Controls.SetChildIndex(this.labSelect, 0);
            this.MenuLayout.Controls.SetChildIndex(this.closebtn, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMaxShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMinShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnSeting, 0);
            // 
            // BodyLayou
            // 
            this.BodyLayou.Controls.Add(this.SpBody);
            this.BodyLayou.Location = new System.Drawing.Point(0, 66);
            this.BodyLayou.Padding = new System.Windows.Forms.Padding(0, 0, 10, 5);
            this.BodyLayou.Size = new System.Drawing.Size(1125, 430);
            // 
            // btnMinShow
            // 
            this.btnMinShow.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btnMinShow.FlatAppearance.BorderSize = 0;
            this.btnMinShow.Location = new System.Drawing.Point(975, 6);
            this.btnMinShow.Margin = new System.Windows.Forms.Padding(0);
            this.btnMinShow.Size = new System.Drawing.Size(42, 48);
            // 
            // btnMaxShow
            // 
            this.btnMaxShow.FlatAppearance.BorderSize = 0;
            this.btnMaxShow.Location = new System.Drawing.Point(1020, 3);
            this.btnMaxShow.Size = new System.Drawing.Size(42, 48);
            // 
            // labUserName
            // 
            this.labUserName.AutoSize = true;
            this.labUserName.Font = new System.Drawing.Font("楷体", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.labUserName.ForeColor = System.Drawing.Color.White;
            this.labUserName.Location = new System.Drawing.Point(80, 23);
            this.labUserName.Name = "labUserName";
            this.labUserName.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.labUserName.Size = new System.Drawing.Size(75, 19);
            this.labUserName.TabIndex = 6;
            this.labUserName.Text = "label1";
            // 
            // labSelect
            // 
            this.labSelect.AutoSize = true;
            this.labSelect.ContextMenuStrip = this.selectMenu;
            this.labSelect.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labSelect.ForeColor = System.Drawing.Color.White;
            this.labSelect.Location = new System.Drawing.Point(157, 24);
            this.labSelect.Name = "labSelect";
            this.labSelect.Size = new System.Drawing.Size(18, 18);
            this.labSelect.TabIndex = 7;
            this.labSelect.Text = "∨";
            this.labSelect.Click += new System.EventHandler(this.labSelect_Click);
            // 
            // selectMenu
            // 
            this.selectMenu.AccessibleRole = System.Windows.Forms.AccessibleRole.Window;
            this.selectMenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.selectMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.用户信息ToolStripMenuItem,
            this.toolStripSeparator1,
            this.退出ToolStripMenuItem,
            this.注销ToolStripMenuItem,
            this.注销并最小化ToolStripMenuItem});
            this.selectMenu.Name = "selectMenu";
            this.selectMenu.Size = new System.Drawing.Size(169, 106);
            this.selectMenu.Click += new System.EventHandler(this.selectMenu_Click);
            // 
            // 用户信息ToolStripMenuItem
            // 
            this.用户信息ToolStripMenuItem.Name = "用户信息ToolStripMenuItem";
            this.用户信息ToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.用户信息ToolStripMenuItem.Text = "用户信息";
            this.用户信息ToolStripMenuItem.Click += new System.EventHandler(this.用户信息ToolStripMenuItem_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(165, 6);
            // 
            // 退出ToolStripMenuItem
            // 
            this.退出ToolStripMenuItem.Name = "退出ToolStripMenuItem";
            this.退出ToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.退出ToolStripMenuItem.Text = "退出";
            this.退出ToolStripMenuItem.Click += new System.EventHandler(this.退出ToolStripMenuItem_Click);
            // 
            // 注销ToolStripMenuItem
            // 
            this.注销ToolStripMenuItem.Name = "注销ToolStripMenuItem";
            this.注销ToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.注销ToolStripMenuItem.Text = "注销";
            this.注销ToolStripMenuItem.Click += new System.EventHandler(this.注销ToolStripMenuItem_Click);
            // 
            // 注销并最小化ToolStripMenuItem
            // 
            this.注销并最小化ToolStripMenuItem.Name = "注销并最小化ToolStripMenuItem";
            this.注销并最小化ToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.注销并最小化ToolStripMenuItem.Text = "注销并最小化";
            this.注销并最小化ToolStripMenuItem.Click += new System.EventHandler(this.注销并最小化ToolStripMenuItem_Click);
            // 
            // Task_JC
            // 
            this.Task_JC.Enabled = true;
            this.Task_JC.Tick += new System.EventHandler(this.Task_JC_Tick);
            // 
            // btnSeting
            // 
            this.btnSeting.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSeting.BackColor = System.Drawing.Color.DodgerBlue;
            this.btnSeting.ContextMenuStrip = this.noteSettingSelect;
            this.btnSeting.FlatAppearance.BorderSize = 0;
            this.btnSeting.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSeting.Font = new System.Drawing.Font("宋体", 19F);
            this.btnSeting.ForeColor = System.Drawing.Color.White;
            this.btnSeting.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.btnSeting.Location = new System.Drawing.Point(930, 6);
            this.btnSeting.Name = "btnSeting";
            this.btnSeting.Size = new System.Drawing.Size(42, 48);
            this.btnSeting.TabIndex = 8;
            this.btnSeting.Text = "☼ ";
            this.btnSeting.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.btnSeting.UseVisualStyleBackColor = false;
            this.btnSeting.Click += new System.EventHandler(this.btnSeting_Click);
            // 
            // noteSettingSelect
            // 
            this.noteSettingSelect.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.noteSettingSelect.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.格式化所有ToolStripMenuItem,
            this.退出APPToolStripMenuItem,
            this.toolStripSeparator4,
            this.退出程序ToolStripMenuItem});
            this.noteSettingSelect.Name = "noteSettingSelect";
            this.noteSettingSelect.Size = new System.Drawing.Size(154, 82);
            // 
            // 格式化所有ToolStripMenuItem
            // 
            this.格式化所有ToolStripMenuItem.Name = "格式化所有ToolStripMenuItem";
            this.格式化所有ToolStripMenuItem.Size = new System.Drawing.Size(153, 24);
            this.格式化所有ToolStripMenuItem.Text = "格式化所有";
            this.格式化所有ToolStripMenuItem.Click += new System.EventHandler(this.格式化所有ToolStripMenuItem1_Click);
            // 
            // 退出APPToolStripMenuItem
            // 
            this.退出APPToolStripMenuItem.Name = "退出APPToolStripMenuItem";
            this.退出APPToolStripMenuItem.Size = new System.Drawing.Size(153, 24);
            this.退出APPToolStripMenuItem.Text = "后台运行";
            this.退出APPToolStripMenuItem.Click += new System.EventHandler(this.注销并最小化ToolStripMenuItem_Click);
            // 
            // toolStripSeparator4
            // 
            this.toolStripSeparator4.Name = "toolStripSeparator4";
            this.toolStripSeparator4.Size = new System.Drawing.Size(150, 6);
            // 
            // 退出程序ToolStripMenuItem
            // 
            this.退出程序ToolStripMenuItem.Name = "退出程序ToolStripMenuItem";
            this.退出程序ToolStripMenuItem.Size = new System.Drawing.Size(153, 24);
            this.退出程序ToolStripMenuItem.Text = "退出程序";
            this.退出程序ToolStripMenuItem.Click += new System.EventHandler(this.退出ToolStripMenuItem_Click);
            // 
            // SpBody
            // 
            this.SpBody.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SpBody.IsSplitterFixed = true;
            this.SpBody.Location = new System.Drawing.Point(0, 0);
            this.SpBody.Name = "SpBody";
            // 
            // SpBody.Panel1
            // 
            this.SpBody.Panel1.Controls.Add(this.blocks);
            this.SpBody.Panel1.Controls.Add(this.panel1);
            // 
            // SpBody.Panel2
            // 
            this.SpBody.Panel2.BackColor = System.Drawing.Color.Gainsboro;
            this.SpBody.Size = new System.Drawing.Size(1115, 425);
            this.SpBody.SplitterDistance = 277;
            this.SpBody.TabIndex = 0;
            // 
            // blocks
            // 
            this.blocks.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.blocks.BackColor = System.Drawing.SystemColors.Control;
            this.blocks.ContextMenuStrip = this.contextBlockMenu;
            this.blocks.Font = new System.Drawing.Font("华文楷体", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.blocks.ImageIndex = 0;
            this.blocks.ImageList = this.iconList;
            this.blocks.LineColor = System.Drawing.Color.White;
            this.blocks.Location = new System.Drawing.Point(3, 69);
            this.blocks.Name = "blocks";
            treeNode1.Name = "节点0";
            treeNode1.SelectedImageIndex = 0;
            treeNode1.Text = "节点0";
            this.blocks.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
            treeNode1});
            this.blocks.SelectedImageKey = "Dirtory.jpg";
            this.blocks.ShowNodeToolTips = true;
            this.blocks.Size = new System.Drawing.Size(271, 353);
            this.blocks.TabIndex = 1;
            this.blocks.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.blocks_AfterSelect);
            // 
            // contextBlockMenu
            // 
            this.contextBlockMenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.contextBlockMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.创建类型ToolStripMenuItem,
            this.修改类型ToolStripMenuItem,
            this.删除类型ToolStripMenuItem,
            this.toolStripSeparator6,
            this.导出类型ToolStripMenuItem,
            this.倒入类型ToolStripMenuItem,
            this.toolStripSeparator7,
            this.移动类型ToolStripMenuItem,
            this.复制类型ToolStripMenuItem,
            this.toolStripSeparator8,
            this.格式化所有ToolStripMenuItem1,
            this.刷新ToolStripMenuItem,
            this.现实便签ToolStripMenuItem});
            this.contextBlockMenu.Name = "contextBlockMenu";
            this.contextBlockMenu.Size = new System.Drawing.Size(182, 310);
            // 
            // 创建类型ToolStripMenuItem
            // 
            this.创建类型ToolStripMenuItem.Name = "创建类型ToolStripMenuItem";
            this.创建类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.创建类型ToolStripMenuItem.Text = "创建类型";
            this.创建类型ToolStripMenuItem.Click += new System.EventHandler(this.tsBtnCreateType_Click);
            // 
            // 修改类型ToolStripMenuItem
            // 
            this.修改类型ToolStripMenuItem.Name = "修改类型ToolStripMenuItem";
            this.修改类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.修改类型ToolStripMenuItem.Text = "修改类型";
            this.修改类型ToolStripMenuItem.Click += new System.EventHandler(this.tsBtnCreateType_Click);
            // 
            // 删除类型ToolStripMenuItem
            // 
            this.删除类型ToolStripMenuItem.Name = "删除类型ToolStripMenuItem";
            this.删除类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.删除类型ToolStripMenuItem.Text = "删除类型";
            this.删除类型ToolStripMenuItem.Click += new System.EventHandler(this.tsBtnDelType_Click);
            // 
            // toolStripSeparator6
            // 
            this.toolStripSeparator6.Name = "toolStripSeparator6";
            this.toolStripSeparator6.Size = new System.Drawing.Size(178, 6);
            // 
            // 导出类型ToolStripMenuItem
            // 
            this.导出类型ToolStripMenuItem.Name = "导出类型ToolStripMenuItem";
            this.导出类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.导出类型ToolStripMenuItem.Text = "导出类型";
            this.导出类型ToolStripMenuItem.Click += new System.EventHandler(this.导出类型ToolStripMenuItem_Click);
            // 
            // 倒入类型ToolStripMenuItem
            // 
            this.倒入类型ToolStripMenuItem.Name = "倒入类型ToolStripMenuItem";
            this.倒入类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.倒入类型ToolStripMenuItem.Text = "导入类型";
            this.倒入类型ToolStripMenuItem.Click += new System.EventHandler(this.倒入类型ToolStripMenuItem_Click);
            // 
            // toolStripSeparator7
            // 
            this.toolStripSeparator7.Name = "toolStripSeparator7";
            this.toolStripSeparator7.Size = new System.Drawing.Size(178, 6);
            // 
            // 移动类型ToolStripMenuItem
            // 
            this.移动类型ToolStripMenuItem.Name = "移动类型ToolStripMenuItem";
            this.移动类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.移动类型ToolStripMenuItem.Text = "移动类型";
            this.移动类型ToolStripMenuItem.Click += new System.EventHandler(this.移动类型ToolStripMenuItem_Click);
            // 
            // 复制类型ToolStripMenuItem
            // 
            this.复制类型ToolStripMenuItem.Name = "复制类型ToolStripMenuItem";
            this.复制类型ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.复制类型ToolStripMenuItem.Text = "复制类型";
            this.复制类型ToolStripMenuItem.Click += new System.EventHandler(this.复制类型ToolStripMenuItem_Click);
            // 
            // toolStripSeparator8
            // 
            this.toolStripSeparator8.Name = "toolStripSeparator8";
            this.toolStripSeparator8.Size = new System.Drawing.Size(178, 6);
            // 
            // 格式化所有ToolStripMenuItem1
            // 
            this.格式化所有ToolStripMenuItem1.Name = "格式化所有ToolStripMenuItem1";
            this.格式化所有ToolStripMenuItem1.Size = new System.Drawing.Size(181, 26);
            this.格式化所有ToolStripMenuItem1.Text = "格式化所有";
            this.格式化所有ToolStripMenuItem1.Click += new System.EventHandler(this.格式化所有ToolStripMenuItem1_Click);
            // 
            // 刷新ToolStripMenuItem
            // 
            this.刷新ToolStripMenuItem.Name = "刷新ToolStripMenuItem";
            this.刷新ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.刷新ToolStripMenuItem.Text = "刷新";
            this.刷新ToolStripMenuItem.Click += new System.EventHandler(this.刷新ToolStripMenuItem_Click);
            // 
            // 现实便签ToolStripMenuItem
            // 
            this.现实便签ToolStripMenuItem.Name = "现实便签ToolStripMenuItem";
            this.现实便签ToolStripMenuItem.Size = new System.Drawing.Size(181, 26);
            this.现实便签ToolStripMenuItem.Text = "删除所有";
            this.现实便签ToolStripMenuItem.Click += new System.EventHandler(this.现实便签ToolStripMenuItem_Click);
            // 
            // iconList
            // 
            this.iconList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("iconList.ImageStream")));
            this.iconList.TransparentColor = System.Drawing.Color.Transparent;
            this.iconList.Images.SetKeyName(0, "Dirtory.jpg");
            // 
            // panel1
            // 
            this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.panel1.Controls.Add(this.toolStrip1);
            this.panel1.Location = new System.Drawing.Point(7, 10);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(267, 53);
            this.panel1.TabIndex = 0;
            // 
            // toolStrip1
            // 
            this.toolStrip1.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.toolStrip1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.toolStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsBtnCreateType,
            this.tsBtnDelType,
            this.toolStripSeparator2,
            this.tsBtnExpType,
            this.tsBtnImpType});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(267, 53);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tsBtnCreateType
            // 
            this.tsBtnCreateType.Image = global::NoteSystem.Properties.Resources.Create;
            this.tsBtnCreateType.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsBtnCreateType.Name = "tsBtnCreateType";
            this.tsBtnCreateType.Size = new System.Drawing.Size(63, 50);
            this.tsBtnCreateType.Text = "新建";
            this.tsBtnCreateType.Click += new System.EventHandler(this.tsBtnCreateType_Click);
            // 
            // tsBtnDelType
            // 
            this.tsBtnDelType.Image = global::NoteSystem.Properties.Resources.dle;
            this.tsBtnDelType.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsBtnDelType.Name = "tsBtnDelType";
            this.tsBtnDelType.Size = new System.Drawing.Size(63, 50);
            this.tsBtnDelType.Text = "删除";
            this.tsBtnDelType.Click += new System.EventHandler(this.tsBtnDelType_Click);
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(6, 53);
            // 
            // tsBtnExpType
            // 
            this.tsBtnExpType.Image = global::NoteSystem.Properties.Resources.exp;
            this.tsBtnExpType.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsBtnExpType.Name = "tsBtnExpType";
            this.tsBtnExpType.Size = new System.Drawing.Size(63, 50);
            this.tsBtnExpType.Text = "导出";
            this.tsBtnExpType.Click += new System.EventHandler(this.tsBtnExpType_Click);
            // 
            // tsBtnImpType
            // 
            this.tsBtnImpType.Image = global::NoteSystem.Properties.Resources.imp;
            this.tsBtnImpType.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsBtnImpType.Name = "tsBtnImpType";
            this.tsBtnImpType.Size = new System.Drawing.Size(63, 24);
            this.tsBtnImpType.Text = "导入";
            this.tsBtnImpType.Click += new System.EventHandler(this.tsBtnImpType_Click);
            // 
            // BottomToolStripPanel
            // 
            this.BottomToolStripPanel.Location = new System.Drawing.Point(0, 0);
            this.BottomToolStripPanel.Name = "BottomToolStripPanel";
            this.BottomToolStripPanel.Orientation = System.Windows.Forms.Orientation.Horizontal;
            this.BottomToolStripPanel.RowMargin = new System.Windows.Forms.Padding(3, 0, 0, 0);
            this.BottomToolStripPanel.Size = new System.Drawing.Size(0, 0);
            // 
            // TopToolStripPanel
            // 
            this.TopToolStripPanel.Location = new System.Drawing.Point(0, 0);
            this.TopToolStripPanel.Name = "TopToolStripPanel";
            this.TopToolStripPanel.Orientation = System.Windows.Forms.Orientation.Horizontal;
            this.TopToolStripPanel.RowMargin = new System.Windows.Forms.Padding(3, 0, 0, 0);
            this.TopToolStripPanel.Size = new System.Drawing.Size(0, 0);
            // 
            // RightToolStripPanel
            // 
            this.RightToolStripPanel.Location = new System.Drawing.Point(0, 0);
            this.RightToolStripPanel.Name = "RightToolStripPanel";
            this.RightToolStripPanel.Orientation = System.Windows.Forms.Orientation.Horizontal;
            this.RightToolStripPanel.RowMargin = new System.Windows.Forms.Padding(3, 0, 0, 0);
            this.RightToolStripPanel.Size = new System.Drawing.Size(0, 0);
            // 
            // LeftToolStripPanel
            // 
            this.LeftToolStripPanel.Location = new System.Drawing.Point(0, 0);
            this.LeftToolStripPanel.Name = "LeftToolStripPanel";
            this.LeftToolStripPanel.Orientation = System.Windows.Forms.Orientation.Horizontal;
            this.LeftToolStripPanel.RowMargin = new System.Windows.Forms.Padding(3, 0, 0, 0);
            this.LeftToolStripPanel.Size = new System.Drawing.Size(0, 0);
            // 
            // ContentPanel
            // 
            this.ContentPanel.Size = new System.Drawing.Size(150, 150);
            // 
            // notifyIcon1
            // 
            this.notifyIcon1.ContextMenuStrip = this.cmNotifyMenu;
            this.notifyIcon1.Text = "notifyIcon1";
            this.notifyIcon1.Visible = true;
            this.notifyIcon1.DoubleClick += new System.EventHandler(this.notifyIcon1_DoubleClick);
            this.notifyIcon1.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(this.notifyIcon1_MouseDoubleClick);
            // 
            // cmNotifyMenu
            // 
            this.cmNotifyMenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.cmNotifyMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.打开ToolStripMenuItem,
            this.注销ToolStripMenuItem1,
            this.toolStripSeparator5,
            this.退出ToolStripMenuItem1});
            this.cmNotifyMenu.Name = "cmNotifyMenu";
            this.cmNotifyMenu.Size = new System.Drawing.Size(109, 82);
            // 
            // 打开ToolStripMenuItem
            // 
            this.打开ToolStripMenuItem.Name = "打开ToolStripMenuItem";
            this.打开ToolStripMenuItem.Size = new System.Drawing.Size(108, 24);
            this.打开ToolStripMenuItem.Text = "打开";
            this.打开ToolStripMenuItem.Click += new System.EventHandler(this.打开ToolStripMenuItem_Click);
            // 
            // 注销ToolStripMenuItem1
            // 
            this.注销ToolStripMenuItem1.Name = "注销ToolStripMenuItem1";
            this.注销ToolStripMenuItem1.Size = new System.Drawing.Size(108, 24);
            this.注销ToolStripMenuItem1.Text = "注销";
            this.注销ToolStripMenuItem1.Click += new System.EventHandler(this.注销ToolStripMenuItem1_Click);
            // 
            // toolStripSeparator5
            // 
            this.toolStripSeparator5.Name = "toolStripSeparator5";
            this.toolStripSeparator5.Size = new System.Drawing.Size(105, 6);
            // 
            // 退出ToolStripMenuItem1
            // 
            this.退出ToolStripMenuItem1.Name = "退出ToolStripMenuItem1";
            this.退出ToolStripMenuItem1.Size = new System.Drawing.Size(108, 24);
            this.退出ToolStripMenuItem1.Text = "退出";
            this.退出ToolStripMenuItem1.Click += new System.EventHandler(this.退出ToolStripMenuItem1_Click);
            // 
            // picUserHeadImg
            // 
            this.picUserHeadImg.Location = new System.Drawing.Point(3, 4);
            this.picUserHeadImg.Name = "picUserHeadImg";
            this.picUserHeadImg.Size = new System.Drawing.Size(71, 50);
            this.picUserHeadImg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picUserHeadImg.TabIndex = 5;
            this.picUserHeadImg.TabStop = false;
            // 
            // toolTip1
            // 
            this.toolTip1.AutoPopDelay = 5000;
            this.toolTip1.InitialDelay = 200;
            this.toolTip1.IsBalloon = true;
            this.toolTip1.ReshowDelay = 100;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1125, 508);
            this.MinimumSize = new System.Drawing.Size(1125, 508);
            this.Name = "MainForm";
            this.Text = "MainForm";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.Controls.SetChildIndex(this.MenuLayout, 0);
            this.Controls.SetChildIndex(this.BodyLayou, 0);
            this.MenuLayout.ResumeLayout(false);
            this.MenuLayout.PerformLayout();
            this.BodyLayou.ResumeLayout(false);
            this.selectMenu.ResumeLayout(false);
            this.noteSettingSelect.ResumeLayout(false);
            this.SpBody.Panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.SpBody)).EndInit();
            this.SpBody.ResumeLayout(false);
            this.contextBlockMenu.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.cmNotifyMenu.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picUserHeadImg)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox picUserHeadImg;
        private System.Windows.Forms.Label labUserName;
        private System.Windows.Forms.Label labSelect;
        private System.Windows.Forms.ContextMenuStrip selectMenu;
        private System.Windows.Forms.ToolStripMenuItem 退出ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 注销ToolStripMenuItem;
        private System.Windows.Forms.Timer Task_JC;
        private System.Windows.Forms.Button btnSeting;
        private System.Windows.Forms.SplitContainer SpBody;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TreeView blocks;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton tsBtnCreateType;
        private System.Windows.Forms.ToolStripButton tsBtnDelType;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripButton tsBtnExpType;
        private System.Windows.Forms.ToolStripButton tsBtnImpType;
        private System.Windows.Forms.ImageList iconList;
        private System.Windows.Forms.ContextMenuStrip noteSettingSelect;
        private System.Windows.Forms.ToolStripMenuItem 退出APPToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator4;
        private System.Windows.Forms.ToolStripMenuItem 退出程序ToolStripMenuItem;
        private System.Windows.Forms.NotifyIcon notifyIcon1;
        private System.Windows.Forms.ToolStripPanel BottomToolStripPanel;
        private System.Windows.Forms.ToolStripPanel TopToolStripPanel;
        private System.Windows.Forms.ToolStripPanel RightToolStripPanel;
        private System.Windows.Forms.ToolStripPanel LeftToolStripPanel;
        private System.Windows.Forms.ToolStripContentPanel ContentPanel;
        private System.Windows.Forms.ToolStripMenuItem 注销并最小化ToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip cmNotifyMenu;
        private System.Windows.Forms.ToolStripMenuItem 打开ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 注销ToolStripMenuItem1;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator5;
        private System.Windows.Forms.ToolStripMenuItem 退出ToolStripMenuItem1;
        private System.Windows.Forms.ContextMenuStrip contextBlockMenu;
        private System.Windows.Forms.ToolStripMenuItem 创建类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 修改类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator6;
        private System.Windows.Forms.ToolStripMenuItem 导出类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 倒入类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator7;
        private System.Windows.Forms.ToolStripMenuItem 移动类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 复制类型ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 格式化所有ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator8;
        private System.Windows.Forms.ToolStripMenuItem 格式化所有ToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem 刷新ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 现实便签ToolStripMenuItem;
        private System.Windows.Forms.ToolTip toolTip1;
        private System.Windows.Forms.ToolStripMenuItem 用户信息ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
    }
}