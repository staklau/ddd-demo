package org.example

abstract class Entity<ID : EntityId> {
    abstract val id: ID

    // TODO: override equals and hashCode and base on id
}
