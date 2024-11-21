<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form2
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form2))
        Aboutusbtn = New Label()
        Loginbtn = New Label()
        Studentbtn = New Label()
        Profbtn = New Label()
        Adminbtn = New Label()
        SuspendLayout()
        ' 
        ' Aboutusbtn
        ' 
        Aboutusbtn.AutoSize = True
        Aboutusbtn.BackColor = SystemColors.ButtonHighlight
        Aboutusbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Aboutusbtn.Location = New Point(1237, 45)
        Aboutusbtn.Name = "Aboutusbtn"
        Aboutusbtn.Size = New Size(99, 26)
        Aboutusbtn.TabIndex = 3
        Aboutusbtn.Text = "About us"
        ' 
        ' Loginbtn
        ' 
        Loginbtn.AutoSize = True
        Loginbtn.BackColor = SystemColors.ButtonHighlight
        Loginbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Loginbtn.Location = New Point(1137, 45)
        Loginbtn.Name = "Loginbtn"
        Loginbtn.Size = New Size(71, 26)
        Loginbtn.TabIndex = 2
        Loginbtn.Text = "Log in"
        ' 
        ' Studentbtn
        ' 
        Studentbtn.AutoSize = True
        Studentbtn.BackColor = SystemColors.Control
        Studentbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Underline, GraphicsUnit.Point, CByte(0))
        Studentbtn.Location = New Point(868, 308)
        Studentbtn.Name = "Studentbtn"
        Studentbtn.Size = New Size(156, 26)
        Studentbtn.TabIndex = 4
        Studentbtn.Text = "I am a Student"
        ' 
        ' Profbtn
        ' 
        Profbtn.AutoSize = True
        Profbtn.BackColor = SystemColors.Control
        Profbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Underline, GraphicsUnit.Point, CByte(0))
        Profbtn.Location = New Point(811, 452)
        Profbtn.Name = "Profbtn"
        Profbtn.Size = New Size(272, 26)
        Profbtn.TabIndex = 5
        Profbtn.Text = "I am part of School Faculty"
        ' 
        ' Adminbtn
        ' 
        Adminbtn.AutoSize = True
        Adminbtn.BackColor = SystemColors.Control
        Adminbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Underline, GraphicsUnit.Point, CByte(0))
        Adminbtn.Location = New Point(835, 600)
        Adminbtn.Name = "Adminbtn"
        Adminbtn.Size = New Size(225, 26)
        Adminbtn.TabIndex = 6
        Adminbtn.Text = "I am an Administrator"
        ' 
        ' Form2
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), Image)
        ClientSize = New Size(1398, 747)
        Controls.Add(Adminbtn)
        Controls.Add(Profbtn)
        Controls.Add(Studentbtn)
        Controls.Add(Aboutusbtn)
        Controls.Add(Loginbtn)
        Name = "Form2"
        StartPosition = FormStartPosition.CenterScreen
        Text = "Form2"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Aboutusbtn As Label
    Friend WithEvents Loginbtn As Label
    Friend WithEvents Studentbtn As Label
    Friend WithEvents Profbtn As Label
    Friend WithEvents Adminbtn As Label
End Class
