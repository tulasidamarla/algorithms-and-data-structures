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