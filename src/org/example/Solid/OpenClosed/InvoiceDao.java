package org.example.Solid.OpenClosed;

import org.example.Solid.SingleResponsibility.Invoice;

//initially we had only saveToDB, but later on if we have to add a new mthod saveToFile then we should extend instead
// of modifying like here
public class InvoiceDao {
    Invoice invoice;
    public InvoiceDao(Invoice invoice)
    {
        this.invoice = invoice;
    }
    public void saveToDB(){
        //save to DB
    }
    public void saveToFile(String fileName)
    {
        //save to File
    }
}

// Open for extension but closed for modification.
// This means that a system should improve easily by adding new code instead of changing the code core.
// This way, the core code always retains its unique identity, making it reusable.

interface InvoiceDaoNew {
    void save(String invoice);
}

class DBInvoiceDao implements InvoiceDaoNew{
    @Override
    public void save(String invoice) {
        //Save to DB
    }
}

class FileInvoiceDao implements InvoiceDaoNew{
    @Override
    public void save(String invoice) {
        //Save to File
    }
}




