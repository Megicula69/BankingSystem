<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
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
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Loginbtn = New Label()
        Aboutusbtn = New Label()
        SuspendLayout()
        ' 
        ' Loginbtn
        ' 
        Loginbtn.AutoSize = True
        Loginbtn.BackColor = SystemColors.ButtonHighlight
        Loginbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Loginbtn.Location = New Point(1136, 44)
        Loginbtn.Name = "Loginbtn"
        Loginbtn.Size = New Size(71, 26)
        Loginbtn.TabIndex = 0
        Loginbtn.Text = "Log in"
        ' 
        ' Aboutusbtn
        ' 
        Aboutusbtn.AutoSize = True
        Aboutusbtn.BackColor = SystemColors.ButtonHighlight
        Aboutusbtn.Font = New Font("Berlin Sans FB", 13.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Aboutusbtn.Location = New Point(1236, 44)
        Aboutusbtn.Name = "Aboutusbtn"
        Aboutusbtn.Size = New Size(99, 26)
        Aboutusbtn.TabIndex = 1
        Aboutusbtn.Text = "About us"
        ' 
        ' Form1
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), Image)
        ClientSize = New Size(1398, 747)
        Controls.Add(Aboutusbtn)
        Controls.Add(Loginbtn)
        Name = "Form1"
        StartPosition = FormStartPosition.CenterScreen
        Text = "Form1"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Loginbtn As Label
    Friend WithEvents Aboutusbtn As Label

End Class
