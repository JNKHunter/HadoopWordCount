package tech.eats.art;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by jhunter on 12/14/16.
 */
public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String[] words = value.toString().split("\\b");
            /*for(int i = 0; i < words.length; i++){
                words[i].replaceAll("[^\\w]", "");
                word.set(words[i]);
                context.write(word,one);
            }*/

        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            context.write(word, one);
        }


    }
}
