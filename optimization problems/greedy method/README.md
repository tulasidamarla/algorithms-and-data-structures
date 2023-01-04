## Greedy method

- In Greedy method a problem is solved in stages.
  - In each stage one input is taken from the given problem.
    - If the input is feasible it is included in the solution.
  - By including all feasible inputs an optimal solution is derived
    

    ```
    a = {1,2,3,4,5}
    n = 5(no of elements)

    greedy algo (a, n) {
        for i = 1 to n 
        {
            x = select(a)
            feasible(x) then
            solution = solution + x
        }
    }
    ```