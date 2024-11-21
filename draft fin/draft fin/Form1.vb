Imports System.Reflection.Emit

Public Class Form1

    Private Sub Loginbtn_MouseEnter(sender As Object, e As EventArgs) Handles Loginbtn.MouseEnter
        Loginbtn.ForeColor = Color.Purple
        Loginbtn.Font = New Font(Loginbtn.Font.FontFamily, Loginbtn.Font.Size + 0.6)
    End Sub

    Private Sub Loginbtn_MouseLeave(sender As Object, e As EventArgs) Handles Loginbtn.MouseLeave
        Loginbtn.ForeColor = Color.Black
        Loginbtn.Font = New Font(Loginbtn.Font.FontFamily, Loginbtn.Font.Size - 0.6)
    End Sub

    Private Sub Aboutusbtn_MouseEnter(sender As Object, e As EventArgs) Handles Aboutusbtn.MouseEnter
        Aboutusbtn.ForeColor = Color.Purple
        Aboutusbtn.Font = New Font(Aboutusbtn.Font.FontFamily, Aboutusbtn.Font.Size + 0.6)
    End Sub

    Private Sub Aboutusbtn_MouseLeave(sender As Object, e As EventArgs) Handles Aboutusbtn.MouseLeave
        Aboutusbtn.ForeColor = Color.Black
        Aboutusbtn.Font = New Font(Aboutusbtn.Font.FontFamily, Aboutusbtn.Font.Size - 0.6)
    End Sub

    Private Sub Loginbtn_Click(sender As Object, e As EventArgs) Handles Loginbtn.Click
        Dim Portal As New Form2

        Portal.Show()
        Me.Hide()
    End Sub
End Class
