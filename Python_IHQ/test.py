source = [
    ["3-LAUZON, JEREMY", 0, 0, 1, 2, 1, 2, 1, 2],
    ['9-Forsberg, Filip', 1, 1, 0, 0, 3, 0, 0, 1]
]

analyst = [
    ['9- Forsberg, Filip', 1, 1, 0, 0, 3, 0, 0, 1],
    ["3- LAUZON, JEREMY", 0, 0, 1, 2, 1, 2, 1, 2]   
]

for i in range(len(source)):
    for j in range(len(analyst)):
        if source[i][0] == analyst[j][0]:
            print('True')
        else:
            print('False')

"""for i in range(len(source)):
    for player in analyst:
        try:
            ind = player.index(source[i][0])
            print(ind)
        except ValueError:
            print('Entered except')
            continue"""

ind = None

def search_player(player, analyst_list):

    for index, element in enumerate(analyst_list):
        if element[0] == player[0]:
            return index
    
    return None

for source_player in source:
    """for index, element in enumerate(analyst):
        if element[0] == source_player[0]:
            ind = index
            print(element[0], source_player[0], ind)
            break"""
    
    ind = search_player(source_player, analyst)
    
    if ind is None:
        print('player not found')
        continue
        # This case means that the source_player is not found on the analyst players list
        # Two things can happen:
        # 1 - The player had no stats in game, which means it will not appear on the analyst list and it's stats on the source should be all zero = NO ERRORS
        # 2 - The analyst has errors in its data so this player in game stats should be counted = ERRORS EXIST

    print('player found')

###

