It works always, except sometimes when the first pair arrives, as the two first requests that arrived at this server. Moreover if two requests arrive at the same time it splits the tokens according to the amount of work of its requests. Specifically it gives to request r1 with a1 amount of work tokens depending on a1 / a1 + a2. a2 is the amount of work of the other request. The closer fraction is to 1 the more tokens it assignes. The rest tokens are assigned to the other request.
