List of commits and changes
(line numbers are based on the commit version)

Part C:

    290e641f - Change names of store, parts, and products
    (on mainscreen.html: 19,21,53); Also on this commit, about.html draft is created

Part D:

    c7f6c260 - Add About.html page
    (deleted the about.html draft and create full page About.html as well as adding the navigation on mainscreen.html: 22)

    fcb6a0d9 - fix url
    (this is a wrong fix of navigation link on mainscreen.html: 22, fixed on the next commit)

    6e2affbc - Add About page controller and link to mainscreen
    (created AboutController.java amd fix the navigation link on mainscreen.html: 22)

Part E:

    93f7316a - Add sample inventory to the application, displayed when there is no parts or products on the lists
    (created functions to help create sample parts and products - on MainScreenControllerr.java: 77-114; and actual create parts and products - on MainScreenControllerr.java: 50-67)

    c0831e1f - Associate sample parts with sample products
    (on MainScreenController.java: 100-1003 and 106);
    Also in this commit, I've done some work of the buy button which is commented on next commit
    (On AddProductController.java: 125-129; mainscreen.html: 89)

Part F:

    a740fec3 - Integrate Buy Now button
    (fixed the GetMapping for buyproduct on AddProductController.java: 127-141 to return newly created confirmationbuyproduct.html)

part G:

    a9cabe35 - add min and max value to class Part
    (on Part.java: 31-34,43,47-48,51,56-57,100-115)

    9ad26778 - Add min, max to Part object, Part Form, and rename the file the persistent storage is saved to
    (on MainScreenControllerr.java: 54-48, 77,83-84,89,95-96; on application.properties: 6; on InhousePartForm.html: 24-28; on OutsourcedPartForm.html: 25-30; on mainscreen/html: 41-42,51-52)

part H:

    d3b89dec - add Part minimum validator
    (on Part.java: 4, 20; created MinPartValidator.java; created ValidMinPart.java; fixed InhousePartForm.html: 26-30 and OutsourcedPartForm.html: 28-32 to show new error messages)

    c53ca72d - Fix Min validator and add Max validator for Parts
    (on MinPartValidator.java: 30; created ValidMaxPart.java and MaxPartValidator.java ; on Part.java: add max validator - 4,22)

    7179f40d - Fix max validator
    (on MaxPartValidator.java: 30)

    f3e8f881 - Fix EnufPartsValidator so part inventory always above minimum
    (on EnufPartsValidator: 36)

    04b856a2 - Fix ValidEnufParts message
    (on ValidEnufParts.java: 20)

part I:

    0efcea78 - add unit tests to Part test
    (on PartTest.java: 130-162)

part G+H: Bug fixed

    460ee40b - Fix Min and Max Validator
    (on MinPartValidator.java and MaxPartValidator.java: 29,32-35,37)

part J:

    88e6d2d5 - Remove unused validator - Delete Part Validator
    (on Part.java: 3,20; deleted DeletePartValidator.java, ValidDeletePart.java)






