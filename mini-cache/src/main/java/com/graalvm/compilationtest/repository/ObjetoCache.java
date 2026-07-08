package com.graalvm.compilationtest.repository;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import reactor.core.publisher.Mono;

public class ObjetoCache {

    //private final Long2IntOpenHashMap indexNames = new Long2IntOpenHashMap();
    public final Long2IntOpenHashMap indexIds = new Long2IntOpenHashMap();
    private int indice;
    private int[] removedSlots;
    private int tail;
    private int size;
    private final long[] ids;
    private final byte[][] nombres;
    private static final ObjetoCache INSTANCE = new ObjetoCache();

    private ObjetoCache() {
        size = 0;
        indice = 0;
        ids = new long[65536];
        removedSlots = new int[65536];
        int tail = 0;
        nombres = new byte[65536][];
        indexIds.defaultReturnValue(-1);
    }

    public static ObjetoCache getInstance() {
        return INSTANCE;
    }

    public void agregar(long id, String nombre){        
        byte[] _ascii = nombre.getBytes(StandardCharsets.US_ASCII);
        //int hash = nombre.hashCode(); // pendiente por idear como evitar la colision
        ids[indice] = id;
        nombres[indice] = _ascii;
        //indexNames.put(hash,indice);
        if(tail>0){
            indexIds.put(id,removedSlots[tail-1]);
            removedSlots[tail-1] = -1;
            tail--;
            size++;
        }else if(size < 65535){
            indexIds.put(id,indice);
            indice++;
            size++;
        }
        System.out.println(indexIds);

    }
    /*
    public Mono<Integer> buscarNombre(String nombre){
        int hash = nombre.hashCode();
        int slot = indexNames.get(hash);
        byte[] buscado = nombre.getBytes(StandardCharsets.US_ASCII);
        if(slot == -1){return Mono.just(-1);}
        byte[] guardado = nombres[slot];
        if(Arrays.equals(guardado, buscado)){return Mono.just(slot);}
        return Mono.just(-2);
    }
    */
    public Mono<Integer> buscarId(long id){
        int slot = indexIds.get(id);
        System.out.println(indexIds);
        System.out.println(slot);
        return Mono.just(slot);
    }

    public Boolean deleteById(long id){
        int slot = indexIds.get(id);
        if(slot == -1){return false;}
        ids[slot] = -1;
        nombres[slot] = null;
        indexIds.remove(id);
        size--;
        if(tail <= 0){
            removedSlots[0] = slot;
            tail = 1;
        }
        removedSlots[tail] = slot;
        tail++;
        System.out.println(indexIds);
        return true;
    }

    public Mono<Integer> size(){
        return Mono.just(size);
    }

    public long getId(int posicion){
        return ids[posicion];
    }

    public byte[] getNombre(int posicion){
        return nombres[posicion];
    }

}