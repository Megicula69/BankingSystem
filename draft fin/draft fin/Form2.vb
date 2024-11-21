Public Class Form2


    Private Sub Loginbtn_MouseEnter(sender As Object, e As EventArgs) Handles Loginbtn.MouseEnter
        Loginbtn.ForeColor = Color.Purple
        Loginbtn.Font = New Font(Loginbtn.Font.FontFamily, Loginbtn.Font.Size - 0.6)
    End Sub

    Private Sub Loginbtn_MouseLeave(sender As Object, e As EventArgs) Handles Loginbtn.MouseLeave
        Loginbtn.ForeColor = Color.Purple
        Loginbtn.Font = New Font(Loginbtn.Font.FontFamily, Loginbtn.Font.Size + 0.6)
    End Sub

    Private Sub Aboutusbtn_MouseEnter(sender As Object, e As EventArgs) Handles Aboutusbtn.MouseEnter
        Aboutusbtn.ForeColor = Color.Purple
        Aboutusbtn.Font = New Font(Aboutusbtn.Font.FontFamily, Aboutusbtn.Font.Size + 0.6)
    End Sub

    Private Sub Aboutusbtn_MouseLeave(sender As Object, e As EventArgs) Handles Aboutusbtn.MouseLeave
        Aboutusbtn.ForeColor = Color.Black
        Aboutusbtn.Font = New Font(Aboutusbtn.Font.FontFamily, Aboutusbtn.Font.Size - 0.6)
    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Loginbtn.ForeColor = Color.Purple
        Loginbtn.Font = New Font(Loginbtn.Font.FontFamily, Loginbtn.Font.Size + 0.6)
    End Sub

    Private Sub Studentbtn_(sender As Object, e As EventArgs) Handles Studentbtn.MouseEnter
        Studentbtn.ForeColor = Color.Purple
        Dim originalFont As Font = Studentbtn.Font
        Studentbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size + 0.6F), FontStyle.Underline)
    End Sub

    Private Sub Studentbtn_MouseLeave(sender As Object, e As EventArgs) Handles Studentbtn.MouseLeave
        Studentbtn.ForeColor = Color.Black
        Dim originalFont As Font = Studentbtn.Font
        Studentbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size - 0.6F), FontStyle.Underline)
    End Sub

    Private Sub Profbtn_MouseEnter(sender As Object, e As EventArgs) Handles Profbtn.MouseEnter
        Profbtn.ForeColor = Color.Purple
        Dim originalFont As Font = Profbtn.Font
        Profbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size + 0.6F), FontStyle.Underline)
    End Sub

    Private Sub Profbtn_MouseLeave(sender As Object, e As EventArgs) Handles Profbtn.MouseLeave
        Profbtn.ForeColor = Color.Black
        Dim originalFont As Font = Profbtn.Font
        Profbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size - 0.6F), FontStyle.Underline)
    End Sub

    Private Sub Adminbtn_MouseEnter(sender As Object, e As EventArgs) Handles Adminbtn.MouseEnter
        Adminbtn.ForeColor = Color.Purple
        Dim originalFont As Font = Adminbtn.Font
        Adminbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size + 0.6F), FontStyle.Underline)
    End Sub
    Private Sub Adminbtn_MouseLeave(sender As Object, e As EventArgs) Handles Adminbtn.MouseLeave
        Adminbtn.ForeColor = Color.Black
        Dim originalFont As Font = Adminbtn.Font
        Adminbtn.Font = New Font(originalFont.FontFamily, CSng(originalFont.Size - 0.6F), FontStyle.Underline)
    End Sub
End Class