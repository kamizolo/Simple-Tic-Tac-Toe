package tictactoe

fun main() {
    fun hor(grid: MutableList<MutableList<Char>>) : String{
        //check horrizont
        var count = 1
        var x = '0'
        var win = false
        var vinner = '?'
        var imp = 0
        for (i in 0..2) {
            x = grid[i][0]
            if(x == ' ') continue
            for (j in 1..2) {
                if (grid[i][j] == x) count++
            }
            if (count == 3) {
                win = true
                imp++
                vinner = x
            }
            count = 1
        }
        //if (win) println("$x wins")
        if (imp == 0) return "none"
        else if (imp == 1) return "$vinner wins"
        else if (imp > 1) return "Impossible"
        return "false"
    }
    fun ver(grid: MutableList<MutableList<Char>>) : String{
        //check horrizont
        var count = 1
        var x = '0'
        var win = false
        var vinner = '?'
        var imp = 0
        for (i in 0..2) {
            x = grid[0][i]
            if(x == ' ') continue
            for (j in 1..2) {
                if (grid[j][i] == x) count++
            }
            if (count == 3) {
                win = true
                imp++
                vinner = x
            }
            count = 1
        }
        //if (win) println("$x wins")
        if (imp == 0) return "none"
        else if (imp == 1) return "$vinner wins"
        else if (imp > 1) return "Impossible"
        return "false"
    }
    fun dig(grid: MutableList<MutableList<Char>>) : String{

        var x = 0
        var c = '?'
        if (grid[0][0] == grid[1][1])
            if(grid[1][1] == grid[2][2]){
                x++
                c = grid[0][0]
            }

        if (grid[0][2] == grid[1][1])
            if(grid[1][1] == grid[2][0]){
                x++
                c = grid[0][2]
            }

        if (x == 2) return "Impossible"
        else if (x == 1 && c != ' ') return "$c wins"
        return "none"
    }
    fun imp(grid: MutableList<MutableList<Char>>){
        if (hor(grid) == "Impossible" || ver(grid) == "Impossible" || dig(grid) == "Impossible")  {
            println("Impossible")
            return
        }
        //println(hor(grid).substring(2))
        var x = 0
        var o = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (grid[i][j] == 'X') x++
                else if (grid[i][j] == 'O') o++
            }
        }
        if (x - o > 1 || x - o < -1) {
            println("Impossible")
            return
        }

        var win = 0
        if (hor(grid).substring(2) == "wins") win++
        if (ver(grid).substring(2) == "wins") win++
        if (dig(grid).substring(2) == "wins") win++

       // println("win : $win")
        if (win > 1) println("Impossibley")
        else if (win == 1) {
            var w = hor(grid)
            if (w != "none") println(w)
            w = ver(grid)
            if (w != "none") println(w)
            w = dig(grid)
            if (w != "none") println(w)
        } else if (win == 0) {
            if (x + o == 9) println("Draw")
            else println("Game not finished")
        }
    }
    fun prin(grid: MutableList<MutableList<Char>>) {
        println("---------")
        for (i in 0..2) {
            print("| ")
            for (j in 0..2) {
                print("${grid[i][j]} ")
            }
            println("|")
        }
        println("---------")
    }
    fun draw(grid: MutableList<MutableList<Char>>) {

        var rep = true

        var X = 0
        var o = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (grid[i][j] == 'X') X++
                else if (grid[i][j] == 'O') o++
            }
        }

        var next = 'X'
        if (X == o) next = 'X'
        else if (X < o) next = 'X'
        else next = 'O'

        var x = listOf<String>()
        while(rep) {
            x = readln().split(" ")
            if (x[0].toInt() !in 0..9 || x[1].toInt() !in 0..9) println("You should enter numbers!")
            else if (x[0].toInt() !in 1..3 || x[1].toInt() !in 1..3) println("Coordinates should be from 1 to 3!")
            else if (grid[x[0].toInt()-1][x[1].toInt()-1] != ' ') println("This cell is occupied! Choose another one!")
            else rep = false

        }
        grid[x[0].toInt()-1][x[1].toInt()-1]  = next

        prin(grid)

    }
    fun play(grid: MutableList<MutableList<Char>>){
        var count = 0
        prin(grid)
        while(true){
            draw(grid)
            count++
            var win = hor(grid)
            if (win.substring(2) == "wins"){
                println(win)
                break
            }
            win = ver(grid)
            if (win.substring(2) == "wins"){
                println(win)
                break
            }
            win = dig(grid)
            if (win.substring(2) == "wins"){
                println(win)
                break
            }
            if (count == 9) {
                println("Draw")
                break
            }
        }


    }

    /*val a = readln()

    val grid = mutableListOf(
        mutableListOf(a[0], a[1], a[2]),
        mutableListOf(a[3], a[4], a[5]),
        mutableListOf(a[6], a[7], a[8])
        )
        */
    val grid = mutableListOf(
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' ')
    )

    //println (grid)
    /*println("---------")
   for (i in a.indices step 3){
        println("| ${a[i]} ${a[i+1]} ${a[i+2]} |") 
    }
    println("---------")*/
    play(grid)

    //imp(grid)


}