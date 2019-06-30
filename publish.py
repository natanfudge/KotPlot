import subprocess
import sys

def ex(command):
	subprocess.run(command.split())

if len(sys.argv) == 1:
	print("Please enter a commit message.")
else:
	# Read the current version
	with open("version.properties") as propertiesFile:
		versionPropertiesStr = propertiesFile.read()
		version = versionPropertiesStr.split("=")[1]
		# Replace the version template with the actual version
		with open ("README_TEMPLATE.md") as templateFile:
			templateContent = templateFile.read()
			readmeFile = open("README.md","w")
			readmeFile.write(templateContent.replace("$VERSION",version))
			readmeFile.close()



	ex("git add .")
	ex("git commit -m \"" + sys.argv[1] + "\"")
	ex("git push")

	
	

