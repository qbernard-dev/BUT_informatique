import mygraph as gr

graphe = {"A " :{"C"},
        "B" : {"C", "E"},
        "C" : {"A", "B", "D", "E"},
        "D" : {"C"},
        "E" : {"C", "B"},
        "F" : dict()}

g = gr.Graphe(graphe)
