class Row:
    def __init__(self, cols=None):
        if isinstance(cols, (list, tuple)):
            self.row = cols
        else:
            self.row = [0.0 for i in range(cols)]

    def __getitem__(self, index):
        return self.row[index]

    def __setitem__(self, index, value):
        self.row[index] = value
    
    def __len__(self):
        return len(self.row)

    def __mul__(self, factor):
        if isinstance(factor, (int, long, float, complex)):
            return Row([_*factor for _ in self.row])
        else:
            raise TypeError

    __rmul__ = __mul__

    def __add__(self, other):
        if isinstance(other, Row):
            return Row([self.row[i]+other.row[i] for i in range(len(self.row))])
        else:
            raise TypeError

    def __sub__(self, other):
        if isinstance(other, Row):
            return Row([self.row[i]-other.row[i] for i in range(len(self.row))])
        else:
            raise TypeError

    def __neg__(self):
        return Row([-self.row[i] for i in range(len(self.row))])

    def __str__(self):
        return ' '.join([str(col) for col in self.row])

class Matrix:
    def __init__(self, cols, rows):
        self.rows = [Row(cols) for i in range(rows)]

    def rowcount(self):
        return len(self.rows)

    def colcount(self):
        return len(self.rows[0])

    def __getitem__(self, index):
        return self.rows[index]

    def __setitem__(self, index, value):
        self.rows[index] = value

    def swap(self, r1, r2):
        self.rows[r1], self.rows[r2] = self.rows[r2], self.rows[r1]

    def __str__(self):
        return '\n'.join([str(row) for row in self.rows])

def loadFromFile(filename):
    f = open(filename)

    cols, rows = f.readline().split()
    m = Matrix(int(cols), int(rows))

    i = 0
    for line in f:
        m[i] = Row([int(_) for _ in line.split()])
        i += 1

    return m
