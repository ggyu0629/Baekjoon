using System;

public class MainClass
{
    public static int[,] arr = new int[9, 9];

    public static void Main(string[] args)
    {
        for (int i = 0; i < 9; i++)
        {
            string[] input = Console.ReadLine().Split(' ');
            for (int j = 0; j < 9; j++)
            {
                arr[i, j] = int.Parse(input[j]);
            }
        }

        Sudoku(0, 0);
    }

    public static void Sudoku(int row, int col)
    {
        if (col == 9)
        {
            Sudoku(row + 1, 0);
            return;
        }

        if (row == 9)
        {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    Console.Write(arr[i, j] + " ");
                }
                Console.WriteLine();
            }

            Environment.Exit(0);
        }

        if (arr[row, col] == 0)
        {
            for (int i = 1; i <= 9; i++)
            {
                if (Possibility(row, col, i))
                {
                    arr[row, col] = i;
                    Sudoku(row, col + 1);
                }
            }
            arr[row, col] = 0;
            return;
        }

        Sudoku(row, col + 1);
    }

    public static bool Possibility(int row, int col, int value)
    {
        for (int i = 0; i < 9; i++)
        {
            if (arr[row, i] == value)
            {
                return false;
            }
        }

        for (int i = 0; i < 9; i++)
        {
            if (arr[i, col] == value)
            {
                return false;
            }
        }

        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;

        for (int i = setRow; i < setRow + 3; i++)
        {
            for (int j = setCol; j < setCol + 3; j++)
            {
                if (arr[i, j] == value)
                {
                    return false;
                }
            }
        }

        return true;
    }
}