###Huffman coding

- Huffman coding is a variable length compression(or encoding) technique used to reduce the size of data or message.
- Data sent over network using compression technique reduces the cost and time.

### Types of encoding

- Fixed length encoding
- Variable length encoding

#### Fixed length encoding

- For example consider the below message of size 20 characters but with only 
  5 alphabets from A to E.

    ```
        BCCABBDDAECCBBAEDDCC
    ```
- In computer terminology alphabets are represented using 8 bit ASCII codes. 
  ASCII codes from A to E range from 65(01000001) to 69(01000101).
- To represent the above message of 20 characters it requires 20*8=160 bits.
- Eight bit ascii codes are used to represent 128 letters.  
- As the above message contains only 5 alphabets, they can be represented with 3 bit custom codes.

```
character | frequency | code
----------------------------
    A     |     3     | 000
----------------------------
    B     |     5     | 001
----------------------------
    C     |     6     | 010
----------------------------
    D     |     4     | 011
----------------------------
    E     |     2     | 100
----------------------------
```
- Total no of bits required to represent using fixed length encoding is 20 * 3 = 60.
- For the receiver to decode the above table is required.
  - Table contains original alphabets and custom codes.
  - original alphabets size is 5 * 8 = 40 bits.
  - custom codes size is 5 * 3 = 15 bits.
- Total size is 60 + 40 + 15 = 115 bits.
- Fixed length encoding reduced the size of 20 characters from 160 bytes to 115 bytes.

### Variable length encoding

- Huffman encoding uses variable length encoding.
- If less no of bytes are used for representing characters with high frequency, 
  then total message length is reduced considerably.
- Huffman coding follows optimal merge pattern.
- In this approach all alphabets are arranged in the increasing order of their frequency.
- Merge the smallest ones until a single largest node is reached to form a binary tree like below.

```
                             20
                            /  \
                         0 /    \ 1
                          /      \
                         /        \ 
                        9          \ 
                     0 / \          \
                      5   \          \
                    0/ \ 1 \ 1       11
                    /   \   \     0 /  \ 1
Frequencies        2     3   4     5    6
          
Alphabets          E     A   D     B     C

```
- Edges on the left side are marked 0 and on the right side are marked 1
- Variable length encoding table can be formed from the above tree like this.

```
character | frequency | code
----------------------------
    A     |     3     | 001
----------------------------
    B     |     5     |  10
----------------------------
    C     |     6     |  11
----------------------------
    D     |     4     |  01
----------------------------
    E     |     2     | 000
----------------------------
```





