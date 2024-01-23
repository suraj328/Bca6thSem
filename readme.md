Employee Crud using spring boot hibernate graphql
Project Setup
    1.Install all spring extension of vscode(springboot initializer,dashboard,lambok)
    2.go to search section vscode
    3.type spring initializer or go to spring boot for template
    4. configure project by name affected id group id
    5.choose deependency(spring boot,spring jpa,graphql,devtools and lambok)

After Project Setup
    Create 3 folder inside main/java/packagename
    1.controller(store all end points)
    2.dao (option for extra features implemention)
    3.entity (Crate all table using hibernate )
    4.model (store all temporary data)
    5.repositary( create interface of entity to use entity crud)
    6.service(for providing services for crud for particular entitity)

database setup
    1.go to resources directory then naviagte application properties

graph
    1.naviagte to resources directory
    2.create graphql folder
    3.create schema extension should be graphqls
    4.define schema ,mutation,query
------------------------------
short description of project implemention
step1:Create Entity Package
    entity
        1.First created entity class which create and store data of mention table
        2.Entity Should have default constructor
        3.Must have getter and setter
        4.Must annotation to define each column

Step2:After Entity Created Create Repsitory Pacakge
    repositary
        1.Create Interface for entity that must extends CrudREpositary;
        2.for defining custom you an define method by matching colum name of tale eg.findByColumnName
Step3:After  creating Repositary create Service package
    service
        1.Define Interface for using CrudRepositary of Repsitory(save,update,findByColumn etc)
        2.Describe another implemention class (its for only implemention purpose)
            --> here create instance of Repositary created in step 2
            --> than u can use instance.save,findByColumn() etc
Step4:After Service Package Create Graphql pacakge inside resources
    graphql
        1.create schema with .graphqls extension 
        2.define mutation,query etc
        3.deafult endpoint is /graphql
        4.optional(graphql.servlet.mapping=/graphql) for changing endpoint
        5.query for fetching,mutation for insertion,updating
        6.for mapping with controller
            query->@QueryMapping
            mutation->@MutationMapping
            schema->@SchemaMapping(combine of both query and mutation)
step5:After graphql created create Controller
    controller
        1.create Controller with ControllerName
        2.Define method and map method using graph annotation
    