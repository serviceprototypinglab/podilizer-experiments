#!/usr/bin/env python3

import sys

if len(sys.argv) != 2:
	print("Syntax: {:s} <podilizer-logfile>".format(sys.argv[0]), file=sys.stderr)
	sys.exit(-1)

deltas = {}

with open(sys.argv[1]) as f:
	for line in f:
		if line.startswith("MEASURE"):
			measure, stamp, *tag = line.strip().split(" ")
			tag = " ".join(tag)
			print(measure, stamp, tag)
			delta = int(stamp[1:-1])
			tagsplit = tag.split(":")
			if len(tagsplit) == 2:
				tagname = "Σ" + tagsplit[0]
				deltas[tagname] = deltas.get(tagname, 0) + delta
			else:
				deltas[tag] = deltas.get(tag, 0) + delta

print(deltas)
