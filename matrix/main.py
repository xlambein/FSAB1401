import matrix

m = matrix.loadFromFile("data")

print m

#for col in range(m.colcount()):
col = 0
for row in range(m.rowcount()-col):
    val = m[row][col]
    if val != 0 and val != 1:
        m[row] = m[row]*(1./val)
    
for row in range(m.rowcount()-1):
    val = m[row+1][col]
    if val != 0:
        m[row+1] = m[row+1] - m[0]*val

print m

# For each col
    # For each row:
        # If row[col] != 0
            # Divide row by row[col]

    # For each row but the first:
        # If row[col] != 0
            # From the row, remove the first row
